package com.example.noteapp.state

import com.example.noteapp.data.Note
import com.example.noteapp.enums.SortType

sealed interface NoteEvent {
    object SaveNote: NoteEvent
    data class SortNote(val sortType: SortType ?= SortType.CREATED_TIME) : NoteEvent
    data class DeleteNote(val note: Note): NoteEvent
    data class Title(val title: String): NoteEvent
    data class Content(val content: String): NoteEvent
}