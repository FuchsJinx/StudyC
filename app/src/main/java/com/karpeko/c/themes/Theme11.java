package com.karpeko.c.themes;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Theme11 extends Theme {
    String videoId = "Xk8vRnm6xtc";

    String code = "static void Main(string[] args)\n" +
            "{\n" +
            "    //var 11, var 9\n" +
            "    Console.InputEncoding = Encoding.UTF8;\n" +
            "    Console.OutputEncoding = Encoding.UTF8;\n" +
            "\n" +
            "    Console.Write(\"Введите номер задания: \");\n" +
            "    int ex = Convert.ToInt32(Console.ReadLine());\n" +
            "\n" +
            "    switch (ex)\n" +
            "    {\n" +
            "        case 1:\n" +
            "            for (double i = -Math.PI; i <= Math.PI; i += Math.PI / 4)\n" +
            "                Calculation(i);\n" +
            "            break;\n" +
            "        case 2:\n" +
            "            Console.Write(\"Введите x1: \");\n" +
            "            float x1 = Convert.ToSingle(Console.ReadLine());\n" +
            "            Console.Write(\"Введите y1: \");\n" +
            "            float y1 = Convert.ToSingle(Console.ReadLine());\n" +
            "            Console.Write(\"Введите x2: \");\n" +
            "            float x2 = Convert.ToSingle(Console.ReadLine());\n" +
            "            Console.Write(\"Введите y2: \");\n" +
            "            float y2 = Convert.ToSingle(Console.ReadLine());\n" +
            "            Console.Write(\"Введите x3: \");\n" +
            "            float x3 = Convert.ToSingle(Console.ReadLine());\n" +
            "            Console.Write(\"Введите y3: \");\n" +
            "            float y3 = Convert.ToSingle(Console.ReadLine());\n" +
            "            Console.Write(\"Введите x4: \");\n" +
            "            float x4 = Convert.ToSingle(Console.ReadLine());\n" +
            "            Console.Write(\"Введите y4: \");\n" +
            "            float y4 = Convert.ToSingle(Console.ReadLine());\n" +
            "\n" +
            "            double firstArea = HeronFormula(x1, y1, x2, y2, x3, y3);\n" +
            "            double secondArea = HeronFormula(x2, y2, x3, y3, x4, y4);\n" +
            "            double thirdArea = HeronFormula(x3, y3, x4, y4, x1, y1);\n" +
            "            double foursArea = HeronFormula(x4, y4, x1, y1, x2, y2);\n" +
            "            //Console.WriteLine(firstArea);\n" +
            "            //Console.WriteLine(secondArea);\n" +
            "            //Console.WriteLine(thirdArea);\n" +
            "            //Console.WriteLine(foursArea);\n" +
            "\n" +
            "            Console.WriteLine($\"Ответ: {SmallestArea(firstArea, secondArea, thirdArea, foursArea)}\");\n" +
            "            break;\n" +
            "    }\n" +
            "}\n" +
            "\n" +
            "static void Calculation(double a)\n" +
            "{\n" +
            "    Console.WriteLine($\"x = {Math.Pow(Math.Sin(a), 2)}\");\n" +
            "    Console.WriteLine($\"y = {Math.Pow(Math.Cos(a), 2)}\");\n" +
            "    Console.Write(\"\\n\");\n" +
            "}\n" +
            "\n" +
            "static double SmallestArea(double area1, double area2, double area3, double area4)\n" +
            "{\n" +
            "    return (SmallestArea(area1, area2) < SmallestArea(area3, area4) ? SmallestArea(area1, area2) : SmallestArea(area3, area4));\n" +
            "}\n" +
            "\n" +
            "static double SmallestArea(double area1, double area2)\n" +
            "{\n" +
            "    return (area1 < area2) ? area1 : area2;\n" +
            "}\n" +
            "static double HeronFormula(float x1, float y1, float x2, float y2, float x3, float y3)\n" +
            "{\n" +
            "    double a = VectorLength(x1, y1, x2, y2);\n" +
            "    double b = VectorLength(x2, y2, x3, y3);\n" +
            "    double c = VectorLength(x3, y3, x1, y1);\n" +
            "    double semiPerimetr = (a + b + c) / 2;\n" +
            "    return Math.Sqrt(semiPerimetr * (semiPerimetr - a) * (semiPerimetr - b) * (semiPerimetr - c));\n" +
            "}\n" +
            "\n" +
            "static double VectorLength(float x1, float y1, float x2, float y2)\n" +
            "{\n" +
            "    return Math.Sqrt(Math.Pow(x2 - x1, 2) + Math.Pow(y2 - y1, 2));\n" +
            "}\n";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme11);

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
        onClick(11);
    }
}
