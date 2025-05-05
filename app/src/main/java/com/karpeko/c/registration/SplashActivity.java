package com.karpeko.c.registration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.karpeko.c.MainActivity;
import com.karpeko.c.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
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
    }
}
