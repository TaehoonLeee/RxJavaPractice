package com.example.rxjavapractice.Repository;

import com.example.rxjavapractice.Result;

public interface RepositoryCallback<T> {
    void onComplete(Result<T> result);
}
