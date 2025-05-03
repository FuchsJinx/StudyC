package com.karpeko.c.themes;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Theme19 extends Theme {

    String videoId = "FbCI1kKPaNs";
    String code = "static void Main()\n" +
            "{\n" +
            "    Console.InputEncoding = Encoding.UTF8;\n" +
            "    Console.OutputEncoding = Encoding.UTF8;\n" +
            "\n" +
            "    Console.Write(\"Введите задание: \");\n" +
            "    \n" +
            "    switch(Console.ReadLine())\n" +
            "    {\n" +
            "        case \"1\":\n" +
            "            Queue<string> queue = new Queue<string>();\n" +
            "            queue.Enqueue(\"Клиент 1\");\n" +
            "            queue.Enqueue(\"Клиент 2\");\n" +
            "            queue.Enqueue(\"Клиент 3\");\n" +
            "            queue.Dequeue();\n" +
            "            queue.Dequeue();\n" +
            "            queue.Enqueue(\"Клиент 4\");\n" +
            "            queue.Enqueue(\"Клиент 5\");\n" +
            "            if (queue.Contains(\"Клиент 3\"))\n" +
            "                Console.WriteLine(\"Клиент еще в очереди\");\n" +
            "            else\n" +
            "                Console.Write(\"Клиент уже ушел\");\n" +
            "                break;\n" +
            "        case \"2\":\n" +
            "            Stack<string> history = new Stack<string>();\n" +
            "            history.Push(\"Главная\");\n" +
            "            history.Push(\"Новости\");\n" +
            "            history.Push(\"Профиль\");\n" +
            "\n" +
            "            Console.WriteLine($\"Текущая страница: {history.Peek()}\"); // Профиль\n" +
            "            history.Pop(); // Назад → \"Новости\"\n" +
            "            Console.WriteLine($\"Теперь: {history.Peek()}\"); // Новости\n" +
            "            break;\n" +
            "    }\n" +
            "}";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme19);

        viewAnswer(code);
        initYouTubePlayerView(videoId);
        onClick(19);
    }
}
