package com.karpeko.c.themes;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Theme17 extends Theme {
    String videoId = "rj9KHVLXaME";
    String code = "string file = File.ReadAllText(\"C:\\\\Users\\\\fizik\\\\Desktop\\\\Pr12.txt\");\n" +
            "string newFile = file[0].ToString().ToLower();\n" +
            "for (int i = 1; i < file.Length; i++)\n" +
            "    newFile += (file[i - 1] == ' ' || file[i - 1] == '\\n') ? file[i].ToString().ToLower() : file[i].ToString();\n" +
            "\n" +
            "Console.WriteLine(file);\n" +
            "Console.WriteLine(newFile);\n" +
            "\n" +
            "File.WriteAllText(\"C:\\\\Users\\\\fizik\\\\Desktop\\\\Pr12New.txt\", newFile);\n";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme17);

        viewAnswer(code);
        initYouTubePlayerView(videoId);
        onClick(17);
    }
}
