package org.example.io_file_write_read;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileReadWriteNIO {
    public static void main(String[] args) {
        String fileName = "example.txt"; // Имя файла

        // Запись в файл
        try {
            String content = "Это пример текста для записи в файл.\nВторая строка.";
            Files.write(Paths.get(fileName), content.getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл: " + e.getMessage());
        }

        // Чтение из файла
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            for (String line : lines) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}