package com.karpeko.c.themes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Theme9 extends Theme {

    String videoId = "XXBEPhPzXro";

    String code = "string string1 = Console.ReadLine();\n" +
            "string a = \"\";\n" +
            "string b = \"\";\n" +
            "bool isWord = false;\n" +
            "bool isPalenom = false;\n" +
            "int count = 0;\n" +
            "\n" +
            "for (int i = 0; i < string1.Length; i++)\n" +
            "{\n" +
            "    isWord = (string1[i] != ' ') ? true : false;\n" +
            "    if (isWord)\n" +
            "        a += string1[i];\n" +
            "    else\n" +
            "    {\n" +
            "        for (int j = a.Length - 1; j >= 0; j--)\n" +
            "            b += a[j];\n" +
            "\n" +
            "        isPalenom = (b == a) ? true : false;\n" +
            "\n" +
            "        if (isPalenom && a.Length == 5)\n" +
            "        {\n" +
            "            Console.WriteLine(a);\n" +
            "            count++;\n" +
            "        }\n" +
            "\n" +
            "        a = \"\";\n" +
            "        b = \"\";\n" +
            "    }\n" +
            "\n" +
            "}\n" +
            "\n" +
            "for (int i = a.Length - 1; i >= 0; i--)\n" +
            "    b += a[i];\n" +
            "if (a == b && a.Length == 5)\n" +
            "{\n" +
            "    Console.WriteLine(a);\n" +
            "    count++;\n" +
            "}\n" +
            "Console.WriteLine(count);";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme9);

        viewAnswer(code);
        initYouTubePlayerView(videoId);
        onClick(9);
    }
}
