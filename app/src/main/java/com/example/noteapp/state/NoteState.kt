package com.example.noteapp.state

import com.example.noteapp.data.Note
import com.example.noteapp.enums.SortType

data class NoteState(
    val notes: List<Note> = emptyList(),
    val title: String = "",
    val content: String = "",
    val sortType: SortType = SortType.CREATED_TIME
)
