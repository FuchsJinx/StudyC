package com.karpeko.c.themes.test;

import android.animation.ValueAnimator;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.karpeko.c.R;

public class Quest extends Fragment {

    MediaPlayer right, wrong;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.exam, container, false);
        return view;
    }

    protected void answer(View view, Fragment fragment) {
        right = MediaPlayer.create(getContext(), R.raw.right_answer);
        wrong = MediaPlayer.create(getContext(), R.raw.wrong_answer);

        // Находим все кнопки
        Button isRightButton = view.findViewById(R.id.isRight);
        Button isFalseButton1 = view.findViewById(R.id.isFalse1);
        Button isFalseButton2 = view.findViewById(R.id.isFalse2);
        Button isFalseButton3 = view.findViewById(R.id.isFalse3);

        // Создаем анимации
        ValueAnimator colorAnimGreen = ValueAnimator.ofArgb(
                ContextCompat.getColor(getContext(), R.color.default_button_color),
                ContextCompat.getColor(getContext(), R.color.green)
        );
        colorAnimGreen.setDuration(500);

        ValueAnimator colorAnimRed = ValueAnimator.ofArgb(
                ContextCompat.getColor(getContext(), R.color.default_button_color),
                ContextCompat.getColor(getContext(), R.color.red)
        );
        colorAnimRed.setDuration(500);

        // Обработчик для правильного ответа
        isRightButton.setOnClickListener(v -> {
            // Анимация для правильной кнопки
            colorAnimGreen.addUpdateListener(animator ->
                    isRightButton.setBackgroundColor((int) animator.getAnimatedValue())
            );
            colorAnimGreen.start();

            // Добавляем иконку правильного ответа
            isRightButton.setCompoundDrawablesWithIntrinsicBounds(
                    null, null,
                    AppCompatResources.getDrawable(getContext(), R.drawable.check),
                    null
            );

            soundPlay(right);
            CountingResults.isRightAnswer++;

            // Задержка перед переходом для отображения анимации
            new Handler().postDelayed(() -> transition(fragment), 700);
        });

        // Обработчики для неправильных ответов
        View.OnClickListener wrongAnswerListener = v -> {
            Button clickedButton = (Button)v;

            // Анимация для неправильной кнопки (красный)
            colorAnimRed.addUpdateListener(animator ->
                    clickedButton.setBackgroundColor((int) animator.getAnimatedValue())
            );
            colorAnimRed.start();

            // Анимация для правильной кнопки (зеленый)
            colorAnimGreen.addUpdateListener(animator ->
                    isRightButton.setBackgroundColor((int) animator.getAnimatedValue())
            );
            colorAnimGreen.start();

            // Добавляем иконки
            clickedButton.setCompoundDrawablesWithIntrinsicBounds(
                    null, null,
                    AppCompatResources.getDrawable(getContext(), R.drawable.fail),
                    null
            );
            isRightButton.setCompoundDrawablesWithIntrinsicBounds(
                    null, null,
                    AppCompatResources.getDrawable(getContext(), R.drawable.check),
                    null
            );

            soundPlay(wrong);

            // Задержка перед переходом
            new Handler().postDelayed(() -> transition(fragment), 700);
        };

        isFalseButton1.setOnClickListener(wrongAnswerListener);
        isFalseButton2.setOnClickListener(wrongAnswerListener);
        isFalseButton3.setOnClickListener(wrongAnswerListener);
    }

    private void transition(Fragment fragment) {
        // Отключаем все кнопки во время перехода
        View rootView = getView();
        if (rootView != null) {
            int[] buttonIds = {R.id.isRight, R.id.isFalse1, R.id.isFalse2, R.id.isFalse3};
            for (int id : buttonIds) {
                Button btn = rootView.findViewById(id);
                if (btn != null) btn.setEnabled(false);
            }
        }

        // Анимация перехода между фрагментами
        FragmentTransaction ft = getParentFragmentManager().beginTransaction();
        ft.setCustomAnimations(
                R.anim.slide_in_right,  // enter
                R.anim.slide_out_left // exit
        );
        ft.replace(R.id.fragment_container, fragment);
        ft.commit();
    }

    private void soundPlay(MediaPlayer player) {
        if (player.isPlaying()) {
            player.pause();
            player.seekTo(0);
            player.setLooping(false);
        }
        player.start();
    }
}
