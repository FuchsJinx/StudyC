package com.karpeko.c.registration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.karpeko.c.MainActivity;
import com.karpeko.c.R;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences prefs, sharedPreferences;
    private static final String PREFS_NAME = "ThemePrefs";
    private static final String KEY_THEME = "isDarkTheme";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        boolean isLoggedIn = prefs.getBoolean("isLoggedIn", false);

        if(isLoggedIn){
            // Пользователь уже вошёл, переходим на MainActivity
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            // Пользователь не вошёл, переходим на LoginActivity
            startActivity(new Intent(this, RegistrationActivity.class));
            finish();
        }

        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean isDarkTheme = sharedPreferences.getBoolean(KEY_THEME, false);

        if (isDarkTheme) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            setTheme(R.style.AppTheme_Dark);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            setTheme(R.style.AppTheme_Light);
        }
    }
}
