package com.example.rxjavapractice;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.rxjavapractice.Repository.BasicRepository;

public class BasicViewModel extends AndroidViewModel {
    private final BasicRepository basicRepository;
    private MutableLiveData<Integer> progressiveLiveData = new MutableLiveData<>(0);

    public BasicViewModel(@NonNull Application application) {
        super(application);
        basicRepository = new BasicRepository(
                ((MyApp) application).executorService,
                ((MyApp) application).mainThreadHandler
        );
    }

    public void longTask() {
        basicRepository.longTask(result -> {
            if ( result instanceof Result.Success) {
                progressiveLiveData.postValue(((Result.Success<Integer>) result).data);
            }
        });
    }

    public MutableLiveData<Integer> getProgressiveLiveData() {
        return progressiveLiveData;
    }
}