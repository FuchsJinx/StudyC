package com.karpeko.c.themes;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.karpeko.c.R;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class Theme extends AppCompatActivity {

    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayer youTubePlayer;
    protected boolean isClicked = false;
    Button button;
    TextView codeView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme1);
    }

    protected void initYouTubePlayerView(String videoId) {
        youTubePlayerView = findViewById(R.id.youtube_player_view);
        getLifecycle().addObserver(youTubePlayerView);

        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(YouTubePlayer initializedYouTubePlayer) {
                youTubePlayer = initializedYouTubePlayer;
                youTubePlayer.loadVideo(videoId, 0);

            }
        });
    }

    protected void viewAnswer(String code) {
        codeView = findViewById(R.id.codeView);
        codeView.setOnClickListener(v -> {
            if (!isClicked) {
                isClicked = true;
                codeView.setText(code);
            }
            else {
                isClicked = false;
                codeView.setText("Показать решение...");
            }
        });
    }

    protected void onClick(int index) {
        button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            shared(index);
            finish();
        });
    }

    public void shared(int index) {
        SharedPreferences sharedPreferences = getSharedPreferences("THEME_PROGRESS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        String userId = getUserEmail(); // метод получения email текущего пользователя

        String key = userId + "_theme_" + index + "_completed";
        editor.putBoolean(key, true);
        editor.apply();
    }
    private String getUserEmail() {
        SharedPreferences prefs = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        return prefs.getString("email", null); // возвращает email или null, если нет
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        youTubePlayerView.release();
    }
}
