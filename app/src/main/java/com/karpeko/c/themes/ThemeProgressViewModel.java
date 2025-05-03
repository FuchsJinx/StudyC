package com.karpeko.c.themes;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Map;

public class ThemeProgressViewModel extends ViewModel {
    private final MutableLiveData<Integer> progress = new MutableLiveData<>();

    public LiveData<Integer> getProgress() {
        return progress;
    }

    public void updateProgress(Context context, int totalItems) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("THEME_PROGRESS", Context.MODE_PRIVATE);
        Map<String, ?> allEntries = sharedPreferences.getAll();
        int completed = 0;
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            if (entry.getValue() instanceof Boolean && (Boolean) entry.getValue()) {
                completed++;
            }
        }

        progress.setValue((int) (((float) completed / totalItems) * 100));
    }
}
