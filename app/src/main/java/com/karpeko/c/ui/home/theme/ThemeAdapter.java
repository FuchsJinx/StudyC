package com.karpeko.c.ui.home.theme;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.karpeko.c.themes.AllThemes;
import com.karpeko.c.themes.Exam;
import com.karpeko.c.themes.Theme1;
import com.karpeko.c.R;
import com.karpeko.c.themes.Theme10;
import com.karpeko.c.themes.Theme11;
import com.karpeko.c.themes.Theme12;
import com.karpeko.c.themes.Theme13;
import com.karpeko.c.themes.Theme14;
import com.karpeko.c.themes.Theme15;
import com.karpeko.c.themes.Theme16;
import com.karpeko.c.themes.Theme17;
import com.karpeko.c.themes.Theme18;
import com.karpeko.c.themes.Theme19;
import com.karpeko.c.themes.Theme2;
import com.karpeko.c.themes.Theme20;
import com.karpeko.c.themes.Theme3;
import com.karpeko.c.themes.Theme4;
import com.karpeko.c.themes.Theme5;
import com.karpeko.c.themes.Theme6;
import com.karpeko.c.themes.Theme7;
import com.karpeko.c.themes.Theme8;
import com.karpeko.c.themes.Theme9;

import java.util.List;

public class ThemeAdapter extends RecyclerView.Adapter<ThemeAdapter.ThemeViewHolder> {

    private List<Theme> themeList;
    private Context context;


    public ThemeAdapter(List<Theme> themeList, Context context) {
        this.themeList = themeList;
        this.context = context;
    }

    @NonNull
    @Override
    public ThemeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.theme_item, parent, false);
        return new ThemeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ThemeViewHolder holder, int position) {
        Theme theme = themeList.get(position);
        holder.title.setText(theme.getTitle());
    }

    @Override
    public int getItemCount() {
        return themeList.size();
    }

    public class ThemeViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        public ThemeViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textView);
            title.setOnClickListener(v -> {
                switch (title.getText().toString()) {
                    case "Знакомство с Visual Studio":
                        Intent intent = new Intent(context, Theme1.class);
                        context.startActivity(intent);
                        break;
                    case "Типы данных в C#":
                        Intent intent1 = new Intent(context, Theme2.class);
                        context.startActivity(intent1);
                        break;
                    case "Оператор ветвления - if/else if/else":
                        Intent intent2 = new Intent(context, Theme3.class);
                        context.startActivity(intent2);
                        break;
                    case "Оператор множественного выбора - switch":
                        Intent intent3 = new Intent(context, Theme4.class);
                        context.startActivity(intent3);
                        break;
                    case "Циклы while / do...while":
                        Intent intent4 = new Intent(context, Theme5.class);
                        context.startActivity(intent4);
                        break;
                    case "Цикл for / foreach":
                        Intent intent5 = new Intent(context, Theme6.class);
                        context.startActivity(intent5);
                        break;
                    case "Одномерные массивы":
                        Intent intent6 = new Intent(context, Theme7.class);
                        context.startActivity(intent6);
                        break;
                    case "Многомерные массивы":
                        Intent intent7 = new Intent(context, Theme8.class);
                        context.startActivity(intent7);
                        break;
                    case "Строки":
                        Intent intent8 = new Intent(context, Theme9.class);
                        context.startActivity(intent8);
                        break;
                    case "Регулярные выражения":
                        Intent intent9 = new Intent(context, Theme10.class);
                        context.startActivity(intent9);
                        break;
                    case "Методы":
                        Intent intent10 = new Intent(context, Theme11.class);
                        context.startActivity(intent10);
                        break;
                    case "Классы":
                        Intent intent11 = new Intent(context, Theme12.class);
                        context.startActivity(intent11);
                        break;
                    case "Интерфейсы":
                        Intent intent12 = new Intent(context, Theme13.class);
                        context.startActivity(intent12);
                        break;
                    case "Структуры":
                        Intent intent13 = new Intent(context, Theme14.class);
                        context.startActivity(intent13);
                        break;
                    case "Явное и неявное преобразование":
                        Intent intent14 = new Intent(context, Theme15.class);
                        context.startActivity(intent14);
                        break;
                    case "Обработчик исключений try...catch":
                        Intent intent15 = new Intent(context, Theme16.class);
                        context.startActivity(intent15);
                        break;
                    case "Файлы":
                        Intent intent16 = new Intent(context, Theme17.class);
                        context.startActivity(intent16);
                        break;
                    case "Списки":
                        Intent intent17 = new Intent(context, Theme18.class);
                        context.startActivity(intent17);
                        break;
                    case "FIFO / LIFO":
                        Intent intent18 = new Intent(context, Theme19.class);
                        context.startActivity(intent18);
                        break;
                    case "LINQ":
                        Intent intent19 = new Intent(context, Theme20.class);
                        context.startActivity(intent19);
                        break;
                    case "Все и сразу":
                        Intent intent20 = new Intent(context, AllThemes.class);
                        context.startActivity(intent20);
                        break;
                    case "Экзамен":
                        Intent intent21 = new Intent(context, Exam.class);
                        context.startActivity(intent21);
                        break;
                }
            });
        }
    }
}
