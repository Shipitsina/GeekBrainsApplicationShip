package com.example.geekbrainsapplicationship;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    HashMap<Button, String> numbersButton = new HashMap<>();
    HashMap<Button, String> operatorsButton = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initButton ();

    }

    protected void initButton() {

        tv = (TextView) findViewById(R.id.textView);

        numbersButton.put((Button) findViewById(R.id.one), "1");
        numbersButton.put((Button) findViewById(R.id.two), "2");
        numbersButton.put((Button) findViewById(R.id.three), "3");
        numbersButton.put((Button) findViewById(R.id.four), "4");
        numbersButton.put((Button) findViewById(R.id.five), "5");
        numbersButton.put((Button) findViewById(R.id.six), "6");
        numbersButton.put((Button) findViewById(R.id.seven), "7");
        numbersButton.put((Button) findViewById(R.id.eight), "8");
        numbersButton.put((Button) findViewById(R.id.nine), "9");
        numbersButton.put((Button) findViewById(R.id.zero), "0");

        Calculator calculator = new Calculator();

        for (Map.Entry<Button, String> o : numbersButton.entrySet()) {
            o.getKey().setOnClickListener(v -> {
                calculator.setField(o.getValue());
                    tv.setText(calculator.getNum());
                }
            );
        }

        Button btnForDot = (Button) findViewById(R.id.dot);
        btnForDot.setOnClickListener(v -> {
            calculator.setDot();
            tv.setText(calculator.getNum());
        });

        Button btnForPlusMinus = (Button) findViewById(R.id.plus_minus);
        btnForPlusMinus.setOnClickListener(v -> {
            calculator.reverseOverZero();
            tv.setText(calculator.getNum());
        });

        Button btnClear = (Button) findViewById(R.id.clear);
        btnClear.setOnClickListener(v -> {
            calculator.clear();
            tv.setText(calculator.getNum());
        });

        operatorsButton.put((Button) findViewById(R.id.plus), "+");
        operatorsButton.put((Button) findViewById(R.id.minus), "-");
        operatorsButton.put((Button) findViewById(R.id.multiply), "*");
        operatorsButton.put((Button) findViewById(R.id.divide), "/");

        for (Map.Entry<Button, String> o : operatorsButton.entrySet()) {
            o.getKey().setOnClickListener(v -> {
                        calculator.operation(o.getValue());
                        tv.setText(calculator.getNum());
                    }
            );
        }
        Button btnResult = (Button) findViewById(R.id.equals);
        btnResult.setOnClickListener(v -> {
            calculator.result();
            tv.setText(calculator.getNum());
        });
    }
}

