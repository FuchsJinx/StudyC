package com.karpeko.c.themes;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Theme16 extends Theme {

    String videoId = "ij__675AuqM";

    String code = "static void Main()\n" +
            "{\n" +
            "    Console.InputEncoding = Encoding.UTF8;\n" +
            "    Console.OutputEncoding = Encoding.UTF8;\n" +
            "    string str = null;\n" +
            "gt: try\n" +
            "    {\n" +
            "        if (str == null)\n" +
            "            throw new ArgumentNullException(str);\n" +
            "    }\n" +
            "    catch (Exception ex)\n" +
            "    {\n" +
            "        Console.WriteLine(\"Строка должна иметь значение\");\n" +
            "        Console.Write(\"Введите значение: \");\n" +
            "        str = Console.ReadLine();\n" +
            "        goto gt;\n" +
            "    }\n" +
            "}";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme16);

        viewAnswer(code);
        initYouTubePlayerView(videoId);
        onClick(16);
    }
}
