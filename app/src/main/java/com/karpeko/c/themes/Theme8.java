package com.karpeko.c.themes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Theme8 extends Theme {
    String videoId = "bMjDIIh46BY";

    String code = "Console.Write(\"Введите количество столбцов: \");\n" +
            "int n = Convert.ToInt32(Console.ReadLine());\n" +
            "\n" +
            "Console.Write(\"Введите количество строк: \");\n" +
            "int m = Convert.ToInt32(Console.ReadLine());\n" +
            "\n" +
            "int[,] arr = new int[m, n];\n" +
            "\n" +
            "Random random = new Random();\n" +
            "\n" +
            "//заполняется массив\n" +
            "for (int i = 0; i < m; i++)\n" +
            "    for (int j = 0; j < n; j++)\n" +
            "        arr[i, j] = random.Next(0, 101) - 50;\n" +
            "\n" +
            "//выводится исходный массив\n" +
            "Console.WriteLine(\"\\nИсходный массив\");\n" +
            "for (int i = 0; i < m; i++)\n" +
            "{\n" +
            "    for (int j = 0; j < n; j++)\n" +
            "        Console.Write(arr[i, j] + \" \");\n" +
            "    Console.Write(\"\\n\");\n" +
            "}\n" +
            "\n" +
            "//выводится преобразованный массив (только нечетные строки)\n" +
            "Console.WriteLine(\"\\nПреобразованный массив\");\n" +
            "for (int i = 0; i < m; i++)\n" +
            "    if ((i + 1) % 2 != 0)\n" +
            "    {\n" +
            "        for (int j = 0; j < n; j++)\n" +
            "            Console.Write(arr[i, j] + \" \");\n" +
            "        Console.Write(\"\\n\");\n" +
            "    }";
    String code1 = "internal class Program\n" +
            "{\n" +
            "    static void PrintMatrix(int[,] matrix)\n" +
            "    {\n" +
            "        int rows = matrix.GetLength(0);\n" +
            "        int cols = matrix.GetLength(1);\n" +
            "\n" +
            "        for (int i = 0; i < rows; i++)\n" +
            "        {\n" +
            "            for (int j = 0; j < cols; j++)\n" +
            "            {\n" +
            "                Console.Write(matrix[i, j] + \"\\t\");\n" +
            "            }\n" +
            "            Console.WriteLine();\n" +
            "        }\n" +
            "    }\n" +
            "    static void Main()\n" +
            "    {\n" +
            "        // Исходная матрица 3x3\n" +
            "        int[,] matrix = {\n" +
            "        { 5, 2, 9 },\n" +
            "        { 1, 8, 4 },\n" +
            "        { 7, 3, 6 }};\n" +
            "\n" +
            "        Console.WriteLine(\"Исходная матрица:\");\n" +
            "        PrintMatrix(matrix);\n" +
            "\n" +
            "        // Преобразуем матрицу в одномерный массив для сортировки\n" +
            "        int rows = matrix.GetLength(0);\n" +
            "        int cols = matrix.GetLength(1);\n" +
            "        int[] flatArray = new int[rows * cols];\n" +
            "\n" +
            "        int index = 0;\n" +
            "        for (int i = 0; i < rows; i++)\n" +
            "        {\n" +
            "            for (int j = 0; j < cols; j++)\n" +
            "            {\n" +
            "                flatArray[index++] = matrix[i, j];\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        // Сортируем одномерный массив\n" +
            "        Array.Sort(flatArray);\n" +
            "\n" +
            "        // Заполняем матрицу отсортированными значениями\n" +
            "        index = 0;\n" +
            "        for (int i = 0; i < rows; i++)\n" +
            "        {\n" +
            "            for (int j = 0; j < cols; j++)\n" +
            "            {\n" +
            "                matrix[i, j] = flatArray[index++];\n" +
            "            }\n" +
            "        }\n" +
            "\n" +
            "        Console.WriteLine(\"\\nМатрица после сортировки:\");\n" +
            "        PrintMatrix(matrix);\n" +
            "    }\n" +
            "}";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme8);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView textCode = findViewById(R.id.code);
        textCode.setText(code1);

        viewAnswer(code);
        initYouTubePlayerView(videoId);
        onClick(8);
    }
}
