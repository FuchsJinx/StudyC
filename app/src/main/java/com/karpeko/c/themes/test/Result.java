package com.karpeko.c.themes.test;

import android.annotation.SuppressLint;
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

import com.airbnb.lottie.LottieAnimationView;
import com.karpeko.c.R;
import com.karpeko.c.notification.SoundClick;

public class Result extends Quest {

    TextView title, text;

    LottieAnimationView animationView;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.result, container, false);

        animationView = view.findViewById(R.id.lottie_animation);

        title = view.findViewById(R.id.title);
        text = view.findViewById(R.id.text);

        int result = CountingResults.isRightAnswer;
        if (result == 20) {
            title.setText("Вы идеально прошли тест! 5+");
            animationView.setAnimation(R.raw.finish_animation);
            CountingResults.isRightAnswer = 0;
        }
        else if (result > 17) {
            title.setText("Вы прекрасно справились! 5");
            animationView.setAnimation(R.raw.five);
            CountingResults.isRightAnswer = 0;
        }
        else if (result > 14) {
            title.setText("Вы хорошо справились! 4");
            animationView.setAnimation(R.raw.four);
            CountingResults.isRightAnswer = 0;
        }
        else if (result > 10) {
            title.setText("Вы справились удовлетворительно! 3");
            animationView.setAnimation(R.raw.three);
            CountingResults.isRightAnswer = 0;
        }
        else {
            title.setText("Вы завалили экзамен! На пересдачу");
            animationView.setAnimation(R.raw.two);
            CountingResults.isRightAnswer = 0;
            text.setVisibility(View.INVISIBLE);
        }


        text.setText(result + " из " + 20 + " вопросов правильно!");
        animationView.playAnimation();

        onClick(view,22);

        return view;
    }

    protected void onClick(View view, int index) {
        Button button = view.findViewById(R.id.button);
        button.setOnClickListener(v -> {
            SoundClick.soundClick(getContext());
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
