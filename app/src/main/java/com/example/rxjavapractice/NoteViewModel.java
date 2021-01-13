package com.example.rxjavapractice;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.rxjavapractice.Repository.NoteRepository;
import com.example.rxjavapractice.Room.Note;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {
    private NoteRepository noteRepository;
    private LiveData<List<Note>> notes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application,
                ((MyApp) application).executorService,
                ((MyApp) application).mainThreadHandler);
        notes = noteRepository.getAllNotes();
    }

    public void insert(Note note) {
        noteRepository.insert(result -> {
            if( result instanceof Result.Success ) {
                Toast.makeText(getApplication(), "Insertion Success!", Toast.LENGTH_LONG).show();
            }
        }, note);
    }

    public LiveData<List<Note>> getAllNotes() {
        return noteRepository.getAllNotes();
    }
}
