package com.example.rxjavapractice;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.ed);
        textView = findViewById(R.id.tv);

        BehaviorSubject<String> subject = BehaviorSubject.createDefault("0");

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Log.d("test", "test");
                subject.map(dan -> Long.parseLong(editText.getText().toString()))
                        .flatMap(dan -> BehaviorSubject.range(1, 9),
                                (dan, row) -> dan + " x " + row + " = " + (dan * row) + "\n")
                        .scan((x, y) -> x + y)
                        .doOnNext(data -> Log.d("onNext()", data))
                        .subscribe(text -> textView.setText(text), Throwable::getMessage);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private EditText editText;
    private TextView textView;
}
