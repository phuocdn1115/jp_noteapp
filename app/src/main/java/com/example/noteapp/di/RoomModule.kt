package com.example.noteapp.di

import android.content.Context
import androidx.room.Room
import com.example.noteapp.dao.NoteDAO
import com.example.noteapp.database.NoteDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    fun provideRoomDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(context, NoteDatabase::class.java,"note.db")
            .build()
    }

    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase): NoteDAO {
        return noteDatabase.dao
    }
}