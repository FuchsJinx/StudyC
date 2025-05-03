package com.karpeko.c.themes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class AllThemes extends Theme {

    String videoId = "w8rRhAup4kg";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_themes);

        TextView textView = findViewById(R.id.textLink1);
        textView.setOnClickListener(v -> {
            String url = "https://learn.microsoft.com/ru-ru/dotnet/csharp/tour-of-csharp/";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        });

        TextView textView1 = findViewById(R.id.textLink2);
        textView1.setOnClickListener(v -> {
            String url = "https://metanit.com/sharp/tutorial/";
            Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent1);
        });

        initYouTubePlayerView(videoId);
        onClick(21);
    }
}
