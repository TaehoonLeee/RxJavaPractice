package com.example.rxjavapractice.Repository;

import android.app.Application;
import android.os.Handler;

import androidx.lifecycle.LiveData;

import com.example.rxjavapractice.Result;
import com.example.rxjavapractice.Room.Note;
import com.example.rxjavapractice.Room.NoteDao;
import com.example.rxjavapractice.Room.NoteDatabase;

import java.util.List;
import java.util.concurrent.Executor;

public class NoteRepository {
    private NoteDao noteDao;
    private LiveData<List<Note>> notes;
    private final Executor executor;
    private final Handler resultHandler;

    public NoteRepository(Application application, Executor executor, Handler resultHandler) {
        NoteDatabase noteDatabase = NoteDatabase.getInstance(application);
        noteDao = noteDatabase.noteDao();
        notes = noteDao.getAllNotes();
        this.executor = executor;
        this.resultHandler = resultHandler;
    }

    public LiveData<List<Note>> getAllNotes() {
        return notes;
    }

    public void insert(RepositoryCallback<Note> callback, Note note) {
        executor.execute(() -> {
            try {
                noteDao.insert(note);
                notifyResult(new Result.Success<>(note), callback);
            }catch (Exception e) { notifyResult(new Result.Error<>(e), callback);}
        });
    }

    public void delete(RepositoryCallback<Note> callback, Note note) {
        executor.execute(() -> {
            try {
                noteDao.delete(note);
                notifyResult(new Result.Success<>(note), callback);
            }catch (Exception e) { notifyResult(new Result.Error<>(e), callback);}
        });
    }

    public void deleteAllNotes(RepositoryCallback<Note> callback) {
        executor.execute(() -> {
            try {
                noteDao.deleteAllNotes();
                notifyResult(new Result.Success<>(), callback);
            }catch (Exception e) { notifyResult(new Result.Error<>(e), callback);}
        });
    }

    private void notifyResult(final Result<Note> result, final RepositoryCallback<Note> callback) {
        resultHandler.post( () -> callback.onComplete(result));
    }
}
