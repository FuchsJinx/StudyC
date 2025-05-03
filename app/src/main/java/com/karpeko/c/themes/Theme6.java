package com.karpeko.c.themes;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Theme6 extends Theme {

    String videoId = "YpRSnUkepv8";
    String code = "static void Main(string[] args)\n" +
            "{\n" +
            "    Console.Write(\"Введите верхний порог для цикла: \");\n" +
            "    int UpperThreshold = Convert.ToInt32(Console.ReadLine());\n" +
            "    int count = 0;\n" +
            "\n" +
            "    for (int i = 0; i < UpperThreshold; i++)\n" +
            "        if (i % 3 == 0)\n" +
            "            count++;\n" +
            "\n" +
            "    Console.WriteLine(\"Чисел кратных трем: \" + count);\n" +
            "\n" +
            "    Console.Write(\"Введите слово: \");\n" +
            "    string str = Console.ReadLine();\n" +
            "    count = 0;\n" +
            "\n" +
            "    foreach (char s in str) \n" +
            "        if (s == 'а')\n" +
            "            count++;\n" +
            "\n" +
            "    Console.WriteLine($\"Букв а в слове: {count}\");\n" +
            "}";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme6);

        viewAnswer(code);
        initYouTubePlayerView(videoId);
        onClick(6);
    }
}
