package com.karpeko.c.themes;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Theme14 extends Theme {

    String videoId = "8E9P_lnJ7RI";

    String code = "struct Route\n" +
            "{\n" +
            "    public string Start;\n" +
            "    public string Finish;\n" +
            "    public string Name;\n" +
            "    public void Print() => Console.WriteLine($\"Маршрут {Name} от {Start} до {Finish}\");\n" +
            "}\n" +
            "static void Main(string[] args)\n" +
            "{\n" +
            "    Console.InputEncoding = Encoding.UTF8;\n" +
            "    Console.OutputEncoding = Encoding.UTF8;\n" +
            "\n" +
            "    Route[] routes = new Route[8];\n" +
            "    \n" +
            "\n" +
            "    for (int i = 0; i < routes.Length; i++)\n" +
            "    {\n" +
            "        Console.Write(\"Введите начальную точку маршрута: \");\n" +
            "        routes[i].Start = Console.ReadLine();\n" +
            "        Console.Write(\"Введите конечную точку маршрута: \");\n" +
            "        routes[i].Finish = Console.ReadLine();\n" +
            "        Console.Write(\"Введите номер маршрута: \");\n" +
            "        routes[i].Name = Console.ReadLine();\n" +
            "        Console.WriteLine();\n" +
            "    }\n" +
            "\n" +
            "    for (int i = 0; i < routes.Length - 1; i++)\n" +
            "        for (int j = 0; j < routes.Length - i - 1; j++)\n" +
            "            if (String.Compare(routes[j].Name, routes[j + 1].Name) > 0)\n" +
            "                (routes[j + 1], routes[j]) = (routes[j], routes[j + 1]);\n" +
            "\n" +
            "    int count = 0;\n" +
            "\n" +
            "    foreach (var i in routes)\n" +
            "        i.Print();\n" +
            "\n" +
            "    Console.Write(\"Введите искомый маршрут: \");\n" +
            "    string name = Console.ReadLine();\n" +
            "    for (int i = 0; i < routes.Length; i++)\n" +
            "        if (routes[i].Start == name || routes[i].Finish == name)\n" +
            "        {\n" +
            "            count++;\n" +
            "            routes[i].Print();\n" +
            "        }\n" +
            "\n" +
            "    if (count == 0) Console.WriteLine(\"Таких маршрутов нет\");\n" +
            "}\n" +
            "\n" +
            "\n" +
            "\n" +
            "\nfor (int i = 0; i < routes.Length - 1; i++)\n" +
            "       for (int j = 0; j < routes.Length - i - 1; j++)\n" +
            "           if (String.Compare(routes[j].Name, routes[j + 1].Name) > 0)\n" +
            "               (routes[j + 1], routes[j]) = (routes[j], routes[j + 1]);\n" +
            "\nЭто пу   зырьковая сортировка с использованием картежей (неким подобием структур), запомните эту контсрукцию для удобства использования ";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme14);

        viewAnswer(code);
        initYouTubePlayerView(videoId);
        onClick(14);
    }
}
