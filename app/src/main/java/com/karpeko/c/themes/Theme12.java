package com.karpeko.c.themes;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Theme12 extends Theme {
    String videoId = "lg_D_1KNBek";

    String code = "public class Buyer\n" +
            "{\n" +
            "    public string Surname { get; set; }\n" +
            "    public string Name { get; set; }\n" +
            "    public string Patronymic { get; set; }\n" +
            "    public string Address { get; set; }\n" +
            "    virtual public int CreditCardNumber { get; set; }\n" +
            "    public int BankAccountNumber { get; set; }\n" +
            "\n" +
            "    public void SetSurname(string surname) => Surname = surname;\n" +
            "    public string GetSurname() => Surname;\n" +
            "\n" +
            "    public Print() => Console.WriteLine($”Фамилия: {Surname}, Имя: {Name}, Отчество: {Patronymic});\n" +
            "}\n" +
            "\n" +
            "Основная программа:\n" +
            "Console.Write(\"Введите количество покупателей: \");\n" +
            "int buyersCount = Convert.ToInt32(Console.ReadLine());\n" +
            "\n" +
            "Buyer[] buyers = new Buyer[buyersCount];\n" +
            "\n" +
            "for (int i = 0; i < buyersCount; i++)\n" +
            "{\n" +
            "    buyers[i] = new Buyer();\n" +
            "\n" +
            "\n" +
            "\n" +
            "    Console.Write($\"Фамилия покупателя {i + 1}: \");\n" +
            "    buyers[i].Surname = Console.ReadLine();\n" +
            "\n" +
            "    Console.Write(\"Имя покупателя: \");\n" +
            "    buyers[i].Name = Console.ReadLine();\n" +
            "\n" +
            "    Console.Write(\"Отчество покупателя: \");\n" +
            "    buyers[i].Patronymic = Console.ReadLine();\n" +
            "\n" +
            "    Console.Write(\"Адресс покупателя: \");\n" +
            "    buyers[i].Address = Console.ReadLine();\n" +
            "\n" +
            "    Console.Write(\"Номер кредитной карты покупателя: \");\n" +
            "    buyers[i].CreditCardNumber = Convert.ToInt32(Console.ReadLine());\n" +
            "\n" +
            "    Console.Write(\"Номер банковского счета покупателя: \");\n" +
            "    buyers[i].BankAccountNumber = Convert.ToInt32(Console.ReadLine());\n" +
            "\n" +
            "    Console.Write(\"\\n\");\n" +
            "}\n" +
            "\n" +
            "for (int i = 0; i < buyersCount - 1; i++)\n" +
            "    for (int j = 0; j < buyersCount - i - 1; j++)\n" +
            "        if (String.Compare(buyers[j].Surname, buyers[j + 1].Surname) > 0)\n" +
            "            (buyers[j + 1], buyers[j]) = (buyers[j], buyers[j + 1]);\n" +
            "\n" +
            "Console.WriteLine(\"Спиоск покупателей:\\n\");\n" +
            "foreach (var buyer in buyers)\n" +
            "    Console.WriteLine($\"{buyer.Surname} {buyer.Name} {buyer.Patronymic}\");\n" +
            "\n" +
            "Console.Write(\"\\n\");\n" +
            "\n" +
            "Console.Write(\"Введите нижний порог диапозона номера кредитной карты: \");\n" +
            "int loverThershold = Convert.ToInt32(Console.ReadLine());\n" +
            "\n" +
            "Console.Write(\"Введите верхний порог диапозона номера кредитной карты: \");\n" +
            "int upperThershold = Convert.ToInt32(Console.ReadLine());\n" +
            "\n" +
            "Console.Write(\"\\n\");\n" +
            "Console.WriteLine(\"Покупатели соответсвующие диапозону: \");\n" +
            "\n" +
            "foreach (var buyer in buyers)\n" +
            "    if (buyer.CreditCardNumber > loverThershold && buyer.CreditCardNumber < upperThershold)\n" +
            "        buyer.Print();\n" +
            "}";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme12);

        viewAnswer(code);
        initYouTubePlayerView(videoId);
        onClick(12);
    }
}
