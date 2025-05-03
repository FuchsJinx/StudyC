package com.karpeko.c.themes;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Theme1 extends Theme {

    String videoId = "KJCs6LZHP3c";
    String code = "Нет";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme1);

        viewAnswer(code);
        initYouTubePlayerView(videoId);
        onClick(1);
    }
}
