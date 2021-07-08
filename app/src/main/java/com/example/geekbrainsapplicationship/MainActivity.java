package com.example.geekbrainsapplicationship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView);
        btn1 = (Button) findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setTextSize(20);
                tv.setText("ЖМЯК!!!");
                tv.setTextSize((float) Math.random()*100 + 5);
                tv.setBackgroundColor(Color.parseColor("#FF0000"));
            }

        });

        btn2 = (Button) findViewById(R.id.btnStartActivity2);
        btn2.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), MainActivity2.class);
            startActivity(intent);
        });
    }


}