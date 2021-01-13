package com.example.rxjavapractice;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavapractice.NoteRecyclerView.NoteAdapter;
import com.example.rxjavapractice.Room.Note;
import com.example.rxjavapractice.databinding.ActivitiyNoteBinding;

import java.util.ArrayList;
import java.util.List;

public class NoteActivity extends AppCompatActivity {

    private NoteViewModel noteViewModel;
    private ActivitiyNoteBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitiyNoteBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        RecyclerView recyclerView = binding.recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        NoteAdapter adapter = new NoteAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        noteViewModel = new ViewModelProvider(
                this,
                new ViewModelProvider.AndroidViewModelFactory(this.getApplication()))
                .get(NoteViewModel.class);
        noteViewModel.insert(new Note("title", "description", "1"));
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                adapter.setNotes(notes);
            }
        });
    }
}
