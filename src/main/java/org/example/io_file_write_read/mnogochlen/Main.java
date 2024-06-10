package org.example.io_file_write_read.mnogochlen;

import org.example.io_file_write_read.mnogochlen.util.Utils;

import java.io.IOException;
import java.nio.file.Path;

import static org.example.io_file_write_read.mnogochlen.util.Utils.prompt;

public class Main {
    public static void main(String[] args) {
        String fileName = prompt("Введите наименование файла (без расширения) : ");
        Path path = Path.of(fileName + ".txt");

        String writeOrRead = prompt("Чтение (r), запись (w), выход (q)? ");
        switch (writeOrRead) {
            case "w" -> {
                while (true) {
                    String s = prompt("Введите натуральную степень k : ");
                    if (s.equalsIgnoreCase("q")) {
                        System.out.println("Вы вышли из программы.");
                        break;
                    }
                    if (!Utils.checkInt(s)) {
                        System.out.println("Вы ввели не целое число!");
                        System.exit(0);
                    }
                    int k = Integer.parseInt(s);
                    String result = Mnogochlen.createStringPolynomial(k);
                    System.out.println(result);
                    if (Utils.writeData(path, result)) {
                        System.out.println("Данные сохранены в указанный файл!");
                    }
                }
            }
            case "r" -> {
                try {
                    System.out.println("Данные : ");
                    System.out.println(Utils.readData(path));
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            case "q" -> {
                System.out.println("Вы вышли из программы.");
            }
            default -> {
                System.out.println("Некорректный ввод!");
            }
        }
    }
}

