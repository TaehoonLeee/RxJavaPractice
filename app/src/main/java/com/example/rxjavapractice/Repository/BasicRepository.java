package com.example.rxjavapractice.Repository;

import android.os.Handler;

import com.example.rxjavapractice.Result;

import java.util.concurrent.Executor;

public class BasicRepository {
    private final Executor executor;
    private final Handler resultHandler;

    public BasicRepository(Executor executor, Handler resultHandler) {
        this.executor = executor;
        this.resultHandler = resultHandler;
    }

    public void longTask(RepositoryCallback<Integer> callback) {
        executor.execute(() -> {
            try {
                int num = 0;
                for (int i = 0; i < 100; i++) {
                    num++;
                    notifyResult(new Result.Success<>(num), callback);
                    Thread.sleep(100);
                }
            } catch (Exception e) { notifyResult(new Result.Error<>(e), callback);}
        });
    }

    private void notifyResult(final Result<Integer> result, final RepositoryCallback<Integer> callback) {
            resultHandler.post(() -> callback.onComplete(result));
    }
}
