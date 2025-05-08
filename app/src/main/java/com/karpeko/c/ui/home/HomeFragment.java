package com.karpeko.c.ui.home;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.karpeko.c.databinding.FragmentHomeBinding;
import com.karpeko.c.themes.ThemeProgressViewModel;
import com.karpeko.c.themes.test.CountingResults;
import com.karpeko.c.ui.home.theme.Theme;
import com.karpeko.c.ui.home.theme.ThemeAdapter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView themeList;
    private ThemeAdapter themeAdapter;
    private List<Theme> themes;
    private ThemeProgressViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        SharedPreferences prefs = getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String userId = prefs.getString("email", "default_user@example.com"); // или другой уникальный id

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        viewModel = new ViewModelProvider(this).get(ThemeProgressViewModel.class);
        viewModel.getProgress().observe(getViewLifecycleOwner(), progress -> {
            ProgressBar progressBar = binding.progressBar;
            ObjectAnimator progressAnim = ObjectAnimator.ofInt(progressBar, "progress", 0, progress);
            ObjectAnimator scaleXAnim = ObjectAnimator.ofFloat(progressBar, "scaleX", 1f, 1.05f, 1f);
            ObjectAnimator scaleYAnim = ObjectAnimator.ofFloat(progressBar, "scaleY", 1f, 1.05f, 1f);

            AnimatorSet set = new AnimatorSet();
            set.playTogether(progressAnim, scaleXAnim, scaleYAnim);
            set.setDuration(1200);
            set.start();

            if (progress == 100) {
                LottieAnimationView animationView = binding.animationView;
                animationView.setVisibility(View.VISIBLE);
                animationView.playAnimation();
                animationView.addAnimatorListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        animationView.animate()
                                .alpha(0f)
                                .setDuration(300)
                                .setInterpolator(new AccelerateInterpolator())
                                .withEndAction(() -> animationView.setVisibility(View.GONE))
                                .start();
                    }
                });
            }
        });

        themeList = binding.list;
        themes = new ArrayList<>();
        themes.add(new Theme(1,"Знакомство с Visual Studio"));
        themes.add(new Theme(2,"Типы данных в C#"));
        themes.add(new Theme(3,"Оператор ветвления - if/else if/else"));
        themes.add(new Theme(4,"Оператор множественного выбора - switch"));
        themes.add(new Theme(5,"Циклы while / do...while"));
        themes.add(new Theme(6,"Цикл for / foreach"));
        themes.add(new Theme(7,"Одномерные массивы"));
        themes.add(new Theme(8,"Многомерные массивы"));
        themes.add(new Theme(9,"Строки"));
        themes.add(new Theme(10,"Регулярные выражения"));
        themes.add(new Theme(11,"Методы"));
        themes.add(new Theme(12,"Классы"));
        themes.add(new Theme(13,"Интерфейсы"));
        themes.add(new Theme(14,"Структуры"));
        themes.add(new Theme(15,"Явное и неявное преобразование"));
        themes.add(new Theme(16,"Обработчик исключений try...catch"));
        themes.add(new Theme(17,"Файлы"));
        themes.add(new Theme(18,"Списки"));
        themes.add(new Theme(19,"FIFO / LIFO"));
        themes.add(new Theme(20,"LINQ"));
        themes.add(new Theme(21,"Все и сразу"));
        themes.add(new Theme(22,"Экзамен"));

        viewModel.updateProgress(getContext(), userId, themes.size() - 1);

        themeAdapter = new ThemeAdapter(themes, getContext());
        themeList.setAdapter(themeAdapter);
        themeList.setLayoutManager(new LinearLayoutManager(getContext()));

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progress();
    }

    @Override
    public void onResume() {
        super.onResume();
        progress();
        CountingResults.isRightAnswer = 0;
    }

    private void progress() {
        SharedPreferences prefs = getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String userId = prefs.getString("email", "default_user@example.com"); // или другой уникальный id
        viewModel.updateProgress(getContext(), userId, themes.size() - 1);
    }
}