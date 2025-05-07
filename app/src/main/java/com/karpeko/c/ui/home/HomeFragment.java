package com.karpeko.c.ui.home;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        viewModel = new ViewModelProvider(this).get(ThemeProgressViewModel.class);
        viewModel.getProgress().observe(getViewLifecycleOwner(), progress -> {
            ProgressBar progressBar = binding.progressBar;
            progressBar.setProgress(progress);
        });

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

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

        viewModel.updateProgress(getContext(), userId, themes.size());

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
        viewModel.updateProgress(getContext(), userId, themes.size());
    }
}