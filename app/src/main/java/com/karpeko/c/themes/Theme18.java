package com.karpeko.c.themes;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.karpeko.c.R;

public class Theme18 extends Theme {

    String videoId = "DcqXjL8U7wY";
    String code = "internal class Program\n" +
            "{\n" +
            "    static void Main()\n" +
            "    {\n" +
            "        Console.InputEncoding = Encoding.UTF8;\n" +
            "        Console.OutputEncoding = Encoding.UTF8;\n" +
            "\n" +
            "        List<Book> books = new List<Book>();\n" +
            "        while(true)\n" +
            "        {\n" +
            "            Console.WriteLine(\"\\nПрограмма добавления книг в библиотеку\");\n" +
            "            Console.WriteLine(\"1. Добавить книгу\");\n" +
            "            Console.WriteLine(\"2. Удалить книгу\");\n" +
            "            Console.WriteLine(\"3. Поиск книги\");\n" +
            "            Console.WriteLine(\"4. Вывод каталога\");\n" +
            "            Console.WriteLine(\"5. Изменение статуса книги\");\n" +
            "            Console.WriteLine(\"6. Статистика\");\n" +
            "            Console.WriteLine(\"7. Выход\");\n" +
            "            Console.Write(\"Выберите действие: \");\n" +
            "\n" +
            "            switch (Console.ReadLine())\n" +
            "            {\n" +
            "                case \"1\":\n" +
            "                    books.Add(AddBook());\n" +
            "                    break;\n" +
            "                case \"2\":\n" +
            "                    Console.Write(\"Введите название книги для удаления\");\n" +
            "                    DeleteBook(ref books, Console.ReadLine());\n" +
            "                    break;\n" +
            "                case \"3\":\n" +
            "                    Console.WriteLine(\"\\nПо какому критерию искать: \");\n" +
            "                    Console.WriteLine(\"1. Названию\");\n" +
            "                    Console.WriteLine(\"2. Автору\");\n" +
            "                    Console.WriteLine(\"3. Жанру\");\n" +
            "                    Console.WriteLine(\"4. Году издания\");\n" +
            "                    Console.Write(\"Выберите действие: \");\n" +
            "\n" +
            "                    switch(Console.ReadLine())\n" +
            "                    {\n" +
            "                        case \"1\":\n" +
            "                            Console.Write(\"Введите название книги: \");\n" +
            "                            string nameBook = Console.ReadLine();\n" +
            "                            SearchBook(books, nameBook);\n" +
            "                            break;\n" +
            "                        case \"2\":\n" +
            "                            Console.Write(\"Введите автора книги: \");\n" +
            "                            string author = Console.ReadLine();\n" +
            "                            SearchBook(books, ref author);\n" +
            "                            break;\n" +
            "                        case \"3\":\n" +
            "                            Console.Write(\"Введите жанр книги: \");\n" +
            "                            string gan = Console.ReadLine();\n" +
            "                            SearchBookGan(books, ref gan);\n" +
            "                            break;\n" +
            "                        case \"4\":\n" +
            "                            Console.Write(\"Введите год издания книги: \");\n" +
            "                            int year = Convert.ToInt32(Console.ReadLine());\n" +
            "                            SearchBook(books, year);\n" +
            "                            break;\n" +
            "                    }\n" +
            "                    break;\n" +
            "                case \"4\":\n" +
            "                    Print(books);\n" +
            "                    break;\n" +
            "                case \"5\":\n" +
            "                    Console.Write(\"Введите название книги для изменения: \");\n" +
            "                    string name = Console.ReadLine();\n" +
            "                    for (int i = 0; i  < books.Count; i++)\n" +
            "                        if (books[i].Name == name)\n" +
            "                        {\n" +
            "                            Console.Write(\"Введите станус книги (1 - на руках, 0 - доступна): \");\n" +
            "                            books[i].inHands = Convert.ToBoolean(Convert.ToInt32(Console.ReadLine()));\n" +
            "                        }\n" +
            "                    break;\n" +
            "                case \"6\":\n" +
            "                    Statistics(books); \n" +
            "                    break;\n" +
            "                case \"7\":\n" +
            "                    Console.WriteLine(\"Пока-пока\");\n" +
            "                    return;\n" +
            "\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "\n" +
            "    static Book AddBook()\n" +
            "    {\n" +
            "        Book book = new Book();\n" +
            "        Console.Write(\"Введите название книги: \");\n" +
            "        book.Name = Console.ReadLine();\n" +
            "        Console.Write(\"Введите автора книги: \");\n" +
            "        book.Author = Console.ReadLine();\n" +
            "    gt: Console.Write(\"Введите год издания книги: \");\n" +
            "        book.Year = Convert.ToInt32(Console.ReadLine());\n" +
            "        Console.Write(\"Введите жанр книги: \");\n" +
            "        if (book.Year > 2025)\n" +
            "        {\n" +
            "            Console.WriteLine(\"Год не может быть будущим!\");\n" +
            "            goto gt;\n" +
            "        }\n" +
            "        book.Gan = Console.ReadLine();\n" +
            "        Console.Write(\"Введите станус книги (1 - на руках, 0 - доступна): \");\n" +
            "        book.inHands = Convert.ToBoolean(Convert.ToInt32(Console.ReadLine()));\n" +
            "        return book;\n" +
            "    }\n" +
            "\n" +
            "    static void DeleteBook(ref List<Book> books, string name)\n" +
            "    {\n" +
            "        foreach (var b in books) \n" +
            "            if (b.Name == name)\n" +
            "                books.Remove(b);\n" +
            "    }\n" +
            "\n" +
            "    static void SearchBook(List<Book> books, string name)\n" +
            "    {\n" +
            "        foreach (var b in books)\n" +
            "            if (b.Name == name)\n" +
            "                b.Print();\n" +
            "    }\n" +
            "\n" +
            "    static void SearchBook(List<Book> books, ref string author)\n" +
            "    {\n" +
            "        foreach (var b in books)\n" +
            "            if (b.Author == author)\n" +
            "                b.Print();\n" +
            "    }\n" +
            "\n" +
            "    static void SearchBookGan(List<Book> books, ref string gan)\n" +
            "    {\n" +
            "        foreach (var b in books)\n" +
            "            if (b.Gan == gan)\n" +
            "                b.Print();\n" +
            "    }\n" +
            "\n" +
            "    static void SearchBook(List<Book> books, int year)\n" +
            "    {\n" +
            "        foreach (var b in books)\n" +
            "            if (b.Year == year)\n" +
            "                b.Print();\n" +
            "    }\n" +
            "\n" +
            "    static void Print(List<Book> books)\n" +
            "    {\n" +
            "        foreach (var b in books) \n" +
            "            b.Print(); \n" +
            "    }\n" +
            "\n" +
            "    static void Statistics(List<Book> books)\n" +
            "    {\n" +
            "        int countInHands = 0;\n" +
            "        int countOutHands = 0;\n" +
            "        for (int i = 0; i < books.Count; i++)\n" +
            "        {\n" +
            "            if (books[i].inHands)\n" +
            "                countInHands++;\n" +
            "            else\n" +
            "                countOutHands++;\n" +
            "        }\n" +
            "\n" +
            "        Console.WriteLine(\"Доступно книг: \" + countOutHands);\n" +
            "        Console.WriteLine(\"Книг на руках: \" + countInHands);\n" +
            "    }\n" +
            "\n" +
            "    class Book\n" +
            "    {\n" +
            "        public string Name {  get; set; }\n" +
            "        public string Author { get; set; }\n" +
            "        public int Year { get; set; }\n" +
            "        public string Gan { get; set; }\n" +
            "        public bool inHands { get; set; }\n" +
            "\n" +
            "        public void Print() => Console.WriteLine($\"Название: {Name}, Автор: {Author}, Год издания: {Year} Жанр: {Gan} На руках? {inHands}\");\n" +
            "    }\n" +
            "}";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.theme18);

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
        onClick(18);
    }
}
