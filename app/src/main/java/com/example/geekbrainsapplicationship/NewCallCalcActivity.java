package com.example.geekbrainsapplicationship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class NewCallCalcActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_call_calc);
        Button btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(v -> {
            initImplicitCall();
        });
    }

    private void initImplicitCall() {

        Intent intent = new Intent("calculator");
        startActivity(intent);
    }
}