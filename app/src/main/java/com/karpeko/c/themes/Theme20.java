package com.karpeko.c.themes;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Theme20 extends Theme {

    String videoId = "gF4X3yr0nsA";
    String code = "internal class Program\n" +
            "{\n" +
            "    class Car\n" +
            "    {\n" +
            "        public double MaxSpeed { get; set; }\n" +
            "        public string Color { get; set; }\n" +
            "        public string Constructor { get; set; }\n" +
            "        public int Count { get; set; }\n" +
            "\n" +
            "\n" +
            "        public void Print() => Console.WriteLine($\"Макс.скорость: {MaxSpeed}, Цвет: {Color}, Производитель: {Constructor}, Кол-во мест: {Count}\");\n" +
            "    }\n" +
            "\nstatic void Main(string[] args)\n" +
            "    {\n" +
            "        Console.InputEncoding = Encoding.UTF8;\n" +
            "        Console.OutputEncoding = Encoding.UTF8;\n" +
            "\n" +
            "\nConsole.Write(\"Введите кол-во элементов списка cars: \");\n" +
            "                int n4 = Convert.ToInt32(Console.ReadLine());\n" +
            "                List<Car> cars = new List<Car>(n4);\n" +
            "                for (int i = 0; i < cars.Capacity; i++)\n" +
            "                {\n" +
            "                    Console.WriteLine($\"Введите элемент {i + 1}: \");\n" +
            "                    Car car = new Car();\n" +
            "                    Console.Write(\"Введите максимальную скорость: \");\n" +
            "                    car.MaxSpeed = Convert.ToDouble(Console.ReadLine());\n" +
            "                    Console.Write(\"Введите цвет машины: \");\n" +
            "                    car.Color = Console.ReadLine();\n" +
            "                    Console.Write(\"Введите производителя: \");\n" +
            "                    car.Constructor = Console.ReadLine();\n" +
            "                    Console.Write(\"Введите кол-во мест: \");\n" +
            "                    car.Count = Convert.ToInt32(Console.ReadLine());\n" +
            "                    cars.Add(car);\n" +
            "                }\n" +
            "\n" +
            "                var c = cars.Where(car => car.Constructor == \"BMW\").ToArray();\n" +
            "                foreach(var i in c) \n" +
            "                    i.Print();\n" +
            "\n     }" +
            "\n}";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme20);

        viewAnswer(code);
        initYouTubePlayerView(videoId);
        onClick(20);
    }
}
