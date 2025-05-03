package com.karpeko.c.themes;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Theme10 extends Theme {

    String videoId = "HLBSTuGMiqI";

    String code = "Console.Write(\"Введите текст: \");\n" +
            "string str = Console.ReadLine(); \n" +
            "\n" +
            "string reg = @\"[А-Я]*парол[А-Я]*\";\n" +
            "Regex regex = new Regex(reg, RegexOptions.IgnoreCase);\n" +
            "MatchCollection matchCollection = regex.Matches(str);\n" +
            "foreach (Match match in matchCollection)\n" +
            "    Console.WriteLine(match.Value);\n";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme10);

        viewAnswer(code);
        initYouTubePlayerView(videoId);
        onClick(10);
    }
}
