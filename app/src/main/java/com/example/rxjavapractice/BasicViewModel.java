package com.example.rxjavapractice;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.rxjavapractice.Repository.BasicRepository;
import com.example.rxjavapractice.Repository.RepositoryCallback;

public class BasicViewModel extends AndroidViewModel {
    private final BasicRepository basicRepository;

    public BasicViewModel(@NonNull Application application) {
        super(application);
        basicRepository = new BasicRepository(
                ((MyApp) application).executorService,
                ((MyApp) application).mainThreadHandler
        );
    }

    public void longTask(RepositoryCallback<Integer> callback) {
        basicRepository.longTask(callback);
    }
}
