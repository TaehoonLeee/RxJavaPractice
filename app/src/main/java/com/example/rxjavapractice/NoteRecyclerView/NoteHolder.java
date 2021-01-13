package com.example.rxjavapractice.NoteRecyclerView;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavapractice.R;
import com.example.rxjavapractice.databinding.NoteItemBinding;

public class NoteHolder extends RecyclerView.ViewHolder {
    public TextView titleView;
    public TextView priorityView;
    public TextView descriptionView;
//    private NoteItemBinding binding;

    public NoteHolder(View itemView) {
        super(itemView);
//        titleView = binding.titleTextView;
//        priorityView = binding.priorityTextView;
//        descriptionView = binding.descriptionTextView;
        titleView = itemView.findViewById(R.id.titleTextView);
        priorityView = itemView.findViewById(R.id.priorityTextView);
        descriptionView = itemView.findViewById(R.id.descriptionTextView);
    }
}
