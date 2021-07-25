package com.example.geekbrainsapplicationship;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String NAME_SHARED_PREFERENCE = "NAME_SHARED_PREFERENCE";
    private Calculator calculator;
    public static final String PARAM_RESULT = "PARAM_RESULT";
    public static final String PARAM_THEME = "PARAM_THEME";
    private static final int AppThemeLightCodeStyle = 0;
    private static final int AppThemeDarkCodeStyle = 1;

    TextView tv;
    HashMap<Button, String> numbersButton = new HashMap<>();
    HashMap<Button, String> operatorsButton = new HashMap<>();
    private String param;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        int currentThemeCode = getCodeStyle();
        setTheme(codeStyleToStyleId(currentThemeCode));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.textView);

        if (savedInstanceState == null) {
            calculator = new Calculator();
        } else {
            calculator = savedInstanceState.getParcelable(PARAM_RESULT);
        }
        tv.setText(calculator.getNum());
        initButton();

    }

    private int getCodeStyle() {
        SharedPreferences preferences = getSharedPreferences(NAME_SHARED_PREFERENCE, MODE_PRIVATE);
        int themeCode = getIntent().getIntExtra(PARAM_THEME,R.style.AppThemeLight);
        return preferences.getInt(PARAM_THEME, themeCode);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(PARAM_RESULT, calculator);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    private int codeStyleToStyleId(int codeStyle) {
        switch (codeStyle) {
            case AppThemeDarkCodeStyle:
                return R.style.AppThemeDark;
            case AppThemeLightCodeStyle:
            default:
                return R.style.AppThemeLight;
        }
    }


    protected void initButton() {


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


        for (Map.Entry<Button, String> o : numbersButton.entrySet()) {
            o.getKey().setOnClickListener(v -> {
                        calculator.setField(o.getValue());
                        tv.setText(calculator.getNum());
                        param = calculator.getNum();
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
        Button btnSettings = (Button) findViewById(R.id.settings);
        btnSettings.setOnClickListener(v -> {
            // intent - намерение сменить активити на ChangeThemeActivity.class
            Intent intent = new Intent(this, ChangeThemeActivity.class);
            // метод запускает активити по указанному intent
            startActivity(intent);
        });

    }
}

