package com.example.noteapp.repository

import com.example.noteapp.dao.NoteDAO
import com.example.noteapp.data.Note
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDAO) {
    fun getNoteByCreatedTime() : Flow<List<Note>> =
        noteDao.getNoteByCreatedTime()

    fun getNoteByLastModifiedTime() : Flow<List<Note>> =
        noteDao.getNoteByLastModifiedTime()


    suspend fun deleteNote(note: Note) : Unit = noteDao.deleteNote(note)

    suspend fun insertNote(note: Note) : Unit = noteDao.insertNote(note)

}