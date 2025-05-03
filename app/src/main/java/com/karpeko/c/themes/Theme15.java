package com.karpeko.c.themes;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Theme15 extends Theme {

    String videoId = "cfoec_hRfPU";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme15);

        initYouTubePlayerView(videoId);
        onClick(15);
    }
}
