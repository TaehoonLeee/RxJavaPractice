package com.example.rxjavapractice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.rxjavapractice.databinding.ActivitiyNoteBinding;
import com.example.rxjavapractice.databinding.ActivityNoteAddBinding;

public class NoteAddActivity extends AppCompatActivity {
    private ActivityNoteAddBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityNoteAddBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        setTitle("Add Note");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_top, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_top_plus:
                saveData();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveData() {
        String title = binding.titleInput.getText().toString();
        String description = binding.descriptionInput.getText().toString();
        String priority = binding.priorityInput.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("title", title);
        intent.putExtra("description", description);
        intent.putExtra("priority", priority);
        setResult(RESULT_OK, intent);
        finish();
    }
}
