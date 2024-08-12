package com.example.noteapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.noteapp.dao.NoteDAO
import com.example.noteapp.database.NoteDatabase
import com.example.noteapp.repository.NewNoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(context, NoteDatabase::class.java,"note.db")
            .build()
    }

    @Provides
    @Singleton
    fun provideNoteDao(noteDatabase: NoteDatabase): NoteDAO {
        return noteDatabase.dao
    }
}