package com.example.noteapp.viewmodel

import androidx.core.content.contentValuesOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.dao.NoteDAO
import com.example.noteapp.data.Note
import com.example.noteapp.enums.SortType
import com.example.noteapp.state.NoteEvent
import com.example.noteapp.state.NoteState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@OptIn(ExperimentalCoroutinesApi::class)
class NoteViewModel(private val dao: NoteDAO) : ViewModel() {
    private val _sortType = MutableStateFlow(SortType.CREATED_TIME)
    private val _notes = _sortType.flatMapLatest { sortType ->
        when (sortType) {
            SortType.CREATED_TIME -> dao.getNoteByCreatedTime()
            SortType.LAST_MODIFIED_TIME -> dao.getNoteByLastModifiedTime()
        }
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())

    private val _state = MutableStateFlow(NoteState())
    val state = combine(_state, _sortType, _notes) { state, sortType, notes ->
        state.copy(
            notes = notes,
            sortType = sortType
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), NoteState())

    fun onEvent(event: NoteEvent) {
        when (event) {
            is NoteEvent.DeleteNote -> viewModelScope.launch {
                dao.deleteNote(event.note)
            }

            NoteEvent.SaveNote -> {
                val note = Note(
                    title = state.value.title,
                    content = state.value.content,
                    createdTime = System.currentTimeMillis(),
                    lastModifiedTime = System.currentTimeMillis()
                )
                viewModelScope.launch {
                    dao.insertNote(note)
                }
            }

            is NoteEvent.SortNote -> {
                _sortType.value = event.sortType
            }

            is NoteEvent.Content -> _state.update {
                it.copy(
                    content = event.content
                )
            }

            is NoteEvent.Title -> _state.update {
                it.copy(
                    title = event.title
                )
            }
        }
    }
}