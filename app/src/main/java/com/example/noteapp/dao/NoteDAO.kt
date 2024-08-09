package com.example.noteapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.noteapp.data.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO {

    @Upsert
    suspend fun insertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM  note order by createdTime DESC")
    fun getNoteByCreatedTime(): Flow<List<Note>>

    @Query("SELECT * FROM  note order by lastModifiedTime DESC")
    fun getNoteByLastModifiedTime(): Flow<List<Note>>

}