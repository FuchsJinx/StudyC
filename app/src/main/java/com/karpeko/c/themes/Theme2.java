package com.karpeko.c.themes;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Theme2 extends Theme {
    String videoId = "fNjVCSEXpDM";
    String code = "static void Main(string[] args)\n" +
            "{\n" +
            "    Console.Write(\"Введите имя: \");\n" +
            "    string name = Console.ReadLine();\n" +
            "    Console.Write(\"Введите возраст: \");\n" +
            "    int age = Convert.ToInt32(Console.ReadLine());\n" +
            "\n" +
            "    Console.WriteLine(\"Имя: \" + name);\n" +
            "    Console.WriteLine($\"Возраст: {age}\");\n" +
            "}";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme2);

        viewAnswer(code);
        initYouTubePlayerView(videoId);
        onClick(2);
    }
}
