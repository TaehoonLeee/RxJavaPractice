package com.example.rxjavapractice.UI;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rxjavapractice.BasicViewModel;
import com.example.rxjavapractice.R;
import com.example.rxjavapractice.Repository.RepositoryCallback;
import com.example.rxjavapractice.Result;
import com.example.rxjavapractice.databinding.FragmentBasicBinding;

public class BasicFragment extends Fragment {
    private BasicViewModel viewModel;
    private FragmentBasicBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_basic, container, false);
        binding = FragmentBasicBinding.bind(view);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(
                requireActivity(),
                new ViewModelProvider.AndroidViewModelFactory(requireActivity().getApplication()))
                .get(BasicViewModel.class);

        binding.btnStart.setOnClickListener( v -> viewModel.longTask(new RepositoryCallback<Integer>() {
            @Override
            public void onComplete(Result<Integer> result) {
                if ( result instanceof Result.Success) {
                    binding.progressBar.setProgress(((Result.Success<Integer>) result).data);
                }
            }
        }));
    }
}
