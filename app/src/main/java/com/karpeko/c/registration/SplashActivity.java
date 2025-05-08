package com.karpeko.c.registration;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
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

        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in_start);
        LottieAnimationView view = findViewById(R.id.animation_view);
        view.startAnimation(fadeIn);
        view.playAnimation();


        // Задержка в 3 секунды (3000 миллисекунд)
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                boolean isLoggedIn = prefs.getBoolean("isLoggedIn", false);

                // Пользователь уже вошёл, переходим на MainActivity
                // Пользователь не вошёл, переходим на LoginActivity
                if (isLoggedIn) {
                    view.pauseAnimation();
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                } else {
                    startActivity(new Intent(SplashActivity.this, RegistrationActivity.class));
                }
                finish();

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
        }, 6000);
    }

}
