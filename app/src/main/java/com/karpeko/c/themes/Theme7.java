package com.karpeko.c.themes;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Theme7 extends Theme {

    String videoId = "O6tWN5iPU08";
    String code = "static void Main(string[] args)\n" +
            "{\n" +
            "    Console.Write(\"Введите кол-во элементов: \");\n" +
            "    int n = Convert.ToInt32(Console.ReadLine());\n" +
            "    int[] array = new int[n];\n" +
            "    int sum = 0;\n" +
            "\n" +
            "    for (int i = 0; i < array.Length; i++)\n" +
            "    {\n" +
            "        Console.Write($\"Введите элемент {i + 1}: \");\n" +
            "        array[i] = Convert.ToInt32(Console.ReadLine());\n" +
            "    }\n" +
            "\n" +
            "    for (int i = 0; i < array.Length; i++)\n" +
            "        if (array[i] % 2 == 0)\n" +
            "            sum += array[i];\n" +
            "\n" +
            "    for (int i = array.Length - 1; i >= 1; i--)\n" +
            "    {\n" +
            "        for (int j = 0; j <= i - 1; j++)\n" +
            "        {\n" +
            "            if (array[j] >  array[j + 1])\n" +
            "            {\n" +
            "                int temp = array[j];\n" +
            "                array[j] = array[j + 1];\n" +
            "                array[j + 1] = temp;\n" +
            "            } \n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    foreach (int i in array)\n" +
            "        Console.WriteLine(i);\n" +
            "\n" +
            "    Console.WriteLine(\"Сумма = \" + sum);\n" +
            "}";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme7);

        TextView c1 = findViewById(R.id.c1);
        SharedPreferences sharedPreferences = getSharedPreferences("ThemePrefs", MODE_PRIVATE);
        boolean isDarkTheme = sharedPreferences.getBoolean("isDarkTheme", false);

        if (isDarkTheme) {
            c1.setTextColor(Color.WHITE);
        } else {
            c1.setTextColor(Color.BLACK);
        }

        viewAnswer(code);
        initYouTubePlayerView(videoId);
        onClick(7);
    }
}
