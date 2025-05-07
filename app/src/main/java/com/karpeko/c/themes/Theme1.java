package com.karpeko.c.themes;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegate;

import com.karpeko.c.R;

public class Theme1 extends Theme {

    String videoId = "KJCs6LZHP3c";
    String code = "Нет";

    @SuppressLint({"MissingInflatedId", "LocalSuppress"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme1);

        TextView c1 = findViewById(R.id.c1);
        SharedPreferences sharedPreferences = getSharedPreferences("ThemePrefs", MODE_PRIVATE);
        boolean isDarkTheme = sharedPreferences.getBoolean("isDarkTheme", false);

        if (isDarkTheme) {
            c1.setTextColor(Color.WHITE);
        } else {
            c1.setTextColor(Color.BLACK);
        }

        viewAnswer(code);
        initYouTubePlayerView(videoId);
        onClick(1);
    }
}
