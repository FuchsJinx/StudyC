package com.karpeko.c.notification;

import android.content.Context;
import android.media.MediaPlayer;

import com.karpeko.c.R;

public class SoundClick {

    public static void soundClick(Context context) {
        MediaPlayer click = MediaPlayer.create(context, R.raw.click);
        if (click.isPlaying()) {
            click.pause();
            click.seekTo(0);
            click.setLooping(false);
        }
        click.setVolume(0.5f, 0.5f);
        click.start();
    }
}
