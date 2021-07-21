package com.example.geekbrainsapplicationship;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ChangeThemeActivity extends AppCompatActivity {
    // NAME_SHARED_PREFERENCE  - имя файла настроек
    private static final String NAME_SHARED_PREFERENCE = "SETTINGS";

    //appTheme - имя параметра, который будем менять
    public static final String appTheme = "APP_THEME";

    private static final int AppThemeLightCodeStyle = 0;
    private static final int AppThemeDarkCodeStyle = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        // Устаноавливаем текущую тему (должна быть ДО setContentView)
        int currentThemeCode = getCodeStyle();
        int currentThemeResId = codeStyleToStyleId(currentThemeCode);
        setTheme(currentThemeResId);

        setContentView(R.layout.activity_change_theme);

        Button btn = (Button) findViewById(R.id.back);
        btn.setOnClickListener(v -> {

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(MainActivity.PARAM_THEME, currentThemeCode);
            startActivity(intent);
        });

        initRadioButtons();
    }

    private void initRadioButtons() {
        findViewById(R.id.radioButtonLight).setOnClickListener(v -> {

            // меняем на светлую тему
            setAppTheme(AppThemeLightCodeStyle);
            // перезапускаем активити с новыми настройками
            recreate();
        });
        findViewById(R.id.radioButtonDark).setOnClickListener(v -> {
            setAppTheme(AppThemeDarkCodeStyle);
            recreate();
        });
    }

    private void setAppTheme(int codeStyle) {
        // объявляю переменную preferences - экземпляр класса SharedPreferences и инициализирую
        // в параметрах - имя файла настроек и стандартный режим доступа
        SharedPreferences preferences = getSharedPreferences(NAME_SHARED_PREFERENCE, MODE_PRIVATE);
        // редактируем фаил настроек, в параметре appTheme прописывается codeStyle
        // метод apply нужен, чтобы изменения вступили в силу
        preferences.edit().putInt(appTheme, codeStyle).apply();
    }

    private int codeStyleToStyle() {
        return codeStyleToStyleId(getCodeStyle());
    }

    private int getCodeStyle() {
        SharedPreferences preferences = getSharedPreferences(NAME_SHARED_PREFERENCE, MODE_PRIVATE);
        return preferences.getInt(appTheme, R.style.AppThemeLight);
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
}