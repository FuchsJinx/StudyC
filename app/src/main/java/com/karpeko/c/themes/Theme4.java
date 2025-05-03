package com.karpeko.c.themes;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Theme4 extends Theme {

    String videoId = "KM_VTfygj-E";
    String code = "static void Main(string[] args)\n" +
            "{\n" +
            "    Console.Write(\"Введите команду (привет, погода, время): \");\n" +
            "    string command = Console.ReadLine();\n" +
            "\n" +
            "    switch (command)\n" +
            "    {\n" +
            "        case \"привет\":\n" +
            "            Console.WriteLine(\"Здравствуйте!\");\n" +
            "            break;\n" +
            "        case \"погода\":\n" +
            "            Console.WriteLine(\"Сегодня солнечно!\");\n" +
            "            break;\n" +
            "        case \"время\":\n" +
            "            Console.WriteLine(DateTime.Now);\n" +
            "            break;\n" +
            "        default:\n" +
            "            Console.WriteLine(\"Такой команды нет\");\n" +
            "            break;\n" +
            "\n" +
            "    }\n" +
            "}";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme4);

        viewAnswer(code);
        initYouTubePlayerView(videoId);
        onClick(4);
    }
}
