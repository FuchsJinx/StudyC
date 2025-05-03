package com.karpeko.c.themes;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Theme13 extends Theme {

    String videoId = "8eZy5xiildM";

    String code = "static void Main(string[] args)\n" +
            "{\n" +
            "    Console.InputEncoding = Encoding.UTF8;\n" +
            "    Console.OutputEncoding = Encoding.UTF8;\n" +
            "\n" +
            "    ArrayClass arrayClass = new ArrayClass();\n" +
            "    Console.Write(\"Введите кол-во элементов: \");\n" +
            "    arrayClass.Length = Convert.ToInt32(Console.ReadLine());\n" +
            "\n" +
            "    int count;\n" +
            "    double[] array = arrayClass.FillingArray(arrayClass.Length);\n" +
            "    double product = arrayClass.ProductPositiveElements(array, out count);\n" +
            "    arrayClass.ArrayOutput(array);\n" +
            "    Console.WriteLine();\n" +
            "    arrayClass.Checking(count, product);\n" +
            "\n" +
            "    Console.WriteLine();\n" +
            "\n" +
            "    ArrayClass arrayClass1 = new ArrayClass();\n" +
            "    Console.Write(\"Введите кол-во элементов: \");\n" +
            "    arrayClass1.Length = Convert.ToInt32(Console.ReadLine());\n" +
            "    double[] array1 = arrayClass1.FillingArray();\n" +
            "    double product1 = arrayClass1.ProductPositiveElements(array1, out count);\n" +
            "    arrayClass1.ArrayOutput(array1);\n" +
            "    Console.WriteLine();\n" +
            "    arrayClass1.Checking(count, product1);\n" +
            "\n" +
            "}\n" +
            "\n" +
            "interface IArray\n" +
            "{\n" +
            "    int Length { get; set; }\n" +
            "    double[] FillingArray(int length);\n" +
            "    double ProductPositiveElements(double[] array, out int count);\n" +
            "}\n" +
            "\n" +
            "class ArrayClass : IArray\n" +
            "{\n" +
            "    public int Length { get; set; }\n" +
            "    double[] array;\n" +
            "\n" +
            "    public virtual double[] FillingArray(int length) \n" +
            "    {\n" +
            "        Random random = new Random();\n" +
            "\n" +
            "        array = new double[length];\n" +
            "\n" +
            "        for (int i = 0; i < length; i++)\n" +
            "            array[i] = random.Next(-15, 15);\n" +
            "\n" +
            "        return array;\n" +
            "    }\n" +
            "\n" +
            "    public virtual double[] FillingArray()\n" +
            "    {\n" +
            "        array = new double[Length];\n" +
            "\n" +
            "        for (int i = 0; i < Length; i++)\n" +
            "        {\n" +
            "            Console.Write(\"Введите элемент: \");\n" +
            "            array[i] = Convert.ToDouble(Console.ReadLine());\n" +
            "        }\n" +
            "\n" +
            "        return array;\n" +
            "    }\n" +
            "\n" +
            "    public virtual double ProductPositiveElements(double[] doubles, out int count)\n" +
            "    {\n" +
            "        double product = 1;\n" +
            "        count = 0;\n" +
            "\n" +
            "        for (int i = 0; i < doubles.Length; i++)\n" +
            "        {\n" +
            "            if (doubles[i] > 0) product *= doubles[i];\n" +
            "            else count++;\n" +
            "        }\n" +
            "                \n" +
            "        return product;\n" +
            "    }\n" +
            "\n" +
            "    public void Checking(int count, double product)\n" +
            "    {\n" +
            "        if (product == 1 && count == Length) Console.WriteLine(\"Нет подходящих элементов\");\n" +
            "        else Console.WriteLine($\"Произведение положительных элементов: {product}\");\n" +
            "    }\n" +
            "\n" +
            "    public void ArrayOutput(double[] array)\n" +
            "    {\n" +
            "        foreach (double d in array)\n" +
            "            Console.Write(d + \" \");\n" +
            "    }\n" +
            "}\n";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme13);

        viewAnswer(code);
        initYouTubePlayerView(videoId);
        onClick(13);
    }
}
