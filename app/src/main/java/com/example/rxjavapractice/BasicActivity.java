package com.example.rxjavapractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.os.Bundle;

import com.example.rxjavapractice.databinding.ActivityBasicBinding;

public class BasicActivity extends AppCompatActivity {
    private ActivityBasicBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

//        binding.btnBasic.setOnClickListener( v -> {
//            Navigation.findNavController(v).navigate(R.layout.fragment_basic);
//        });
    }
}
