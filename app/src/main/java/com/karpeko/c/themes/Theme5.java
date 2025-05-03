package com.karpeko.c.themes;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Theme5 extends Theme {

    String videoId = "e0ajLLezBPE";
    String code = "static void Main(string[] args)\n" +
            "{\n" +
            "    Random random = new Random();\n" +
            "    int randomNumber = random.Next(0, 101);\n" +
            "\n" +
            "    Console.Write(\"Мы загадали число от 0 до 100. Угадайте: \");\n" +
            "gt: int answer = Convert.ToInt32(Console.ReadLine());\n" +
            "\n" +
            "    while (answer != randomNumber)\n" +
            "    {\n" +
            "        if (answer > randomNumber)\n" +
            "        {\n" +
            "            Console.WriteLine(\"Загаданное число меньше\");\n" +
            "            goto gt;\n" +
            "        }\n" +
            "        else\n" +
            "        {\n" +
            "            Console.WriteLine(\"Загаданное число больше\");\n" +
            "            goto gt;\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    Console.WriteLine($\"Ура! Вы угадали число. Это: {randomNumber}\");\n" +
            "}";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme5);

        viewAnswer(code);
        initYouTubePlayerView(videoId);
        onClick(5);
    }
}
