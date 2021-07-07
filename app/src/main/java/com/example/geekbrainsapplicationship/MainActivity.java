package com.example.geekbrainsapplicationship;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /*TextView tv;
    Button btn;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
/*
        tv = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setTextSize(20);
                tv.setText("ЖМЯК!!!");
                tv.setTextSize((float) Math.random()*100 + 5);
                tv.setBackgroundColor(Color.parseColor("#FF0000"));
            }

        });*/
    }
}