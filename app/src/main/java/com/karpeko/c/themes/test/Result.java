package com.karpeko.c.themes.test;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Result extends Quest {

    TextView title, text;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result, container, false);

        title = view.findViewById(R.id.title);
        text = view.findViewById(R.id.text);

        int result = CountingResults.isRightAnswer;
        if (result == 20) {
            title.setText("Вы идеально прошли тест! 5+");
            CountingResults.isRightAnswer = 0;
        }
        else if (result > 17) {
            title.setText("Вы прекрасно справились! 5");
            CountingResults.isRightAnswer = 0;
        }
        else if (result > 14) {
            title.setText("Вы хорошо справились! 4");
            CountingResults.isRightAnswer = 0;
        }
        else if (result > 10) {
            title.setText("Вы справились удовлетворительно! 3");
            CountingResults.isRightAnswer = 0;
        }
        else {
            title.setText("Вы завалили экзамен! На пересдачу");
            CountingResults.isRightAnswer = 0;
            text.setVisibility(View.INVISIBLE);
        }


        text.setText(result + " из " + 20 + " вопросов правильно!");

        onClick(view,22);

        return view;
    }

    protected void onClick(View view, int index) {
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(v -> {
            shared(index);
            getActivity().finish();
        });
    }

    public void shared(int index) {
        SharedPreferences sharedPreferences = requireActivity().getSharedPreferences("THEME_PROGRESS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("theme_" + index + "_completed", true);
        editor.apply();
    }
}
