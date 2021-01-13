package com.example.rxjavapractice.Room;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.rxjavapractice.Repository.RepositoryCallback;
import com.example.rxjavapractice.Result;

@Database(entities = {Note.class}, version = 2)
public abstract class NoteDatabase extends RoomDatabase {
    private static NoteDatabase instance;

    public abstract NoteDao noteDao();

    public static synchronized NoteDatabase getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class, "note_database")
                            .fallbackToDestructiveMigration()
                            .build();
        }
        return instance;
    }

}
