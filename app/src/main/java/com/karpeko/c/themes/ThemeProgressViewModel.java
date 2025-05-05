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

    /**
     * Обновляет прогресс для конкретного пользователя.
     * @param context контекст для доступа к SharedPreferences
     * @param userId уникальный идентификатор пользователя (например, email)
     * @param totalItems общее количество элементов для подсчёта прогресса
     */
    public void updateProgress(Context context, String userId, int totalItems) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("THEME_PROGRESS", Context.MODE_PRIVATE);
        Map<String, ?> allEntries = sharedPreferences.getAll();

        int completed = 0;
        // Перебираем только записи, относящиеся к текущему пользователю
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
            String key = entry.getKey();
            // Предполагаем, что ключи имеют формат "userId_itemId"
            if (key.startsWith(userId + "_") && entry.getValue() instanceof Boolean && (Boolean) entry.getValue()) {
                completed++;
            }
        }

        int percent = totalItems > 0 ? (int) (((float) completed / totalItems) * 100) : 0;
        progress.setValue(percent);
    }
}
