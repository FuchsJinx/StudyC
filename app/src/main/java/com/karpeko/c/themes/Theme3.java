package com.karpeko.c.themes;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Theme3 extends Theme {
    String videoId = "z_60JTqpEZI";
    String code = "static void Main(string[] args)\n" +
            "{\n" +
            "    Console.Write(\"Введите температуру в комнате: \");\n" +
            "    int roomTemperature = Convert.ToInt32(Console.ReadLine());\n" +
            "    Console.Write(\"Введите желаемую температуру: \");\n" +
            "    int desiredTemperature = Convert.ToInt32(Console.ReadLine());\n" +
            "\n" +
            "    if (roomTemperature > desiredTemperature)\n" +
            "        Console.WriteLine(\"Включить охлаждение\");\n" +
            "    else if (roomTemperature < desiredTemperature)\n" +
            "        Console.WriteLine(\"Включить обогрев\");\n" +
            "    else\n" +
            "        Console.WriteLine(\"Температура в норме. Система отключена\");\n" +
            "}";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme3);

        viewAnswer(code);
        initYouTubePlayerView(videoId);
        onClick(3);
    }
}
