package com.example.noteapp.repository

import com.example.noteapp.dao.NoteDAO
import com.example.noteapp.data.Note
import com.example.noteapp.database.NoteDatabase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewNoteRepository @Inject constructor(private val noteDAO: NoteDAO){
    fun getNoteByCreatedTime() : Flow<List<Note>> {
        return noteDAO.getNoteByCreatedTime()
    }

    fun getNoteByLastModifiedTime() : Flow<List<Note>> {
        return noteDAO.getNoteByLastModifiedTime()
    }


    suspend fun deleteNote(note: Note) : Unit = noteDAO.deleteNote(note)

    suspend fun insertNote(note: Note) : Unit = noteDAO.insertNote(note)

}