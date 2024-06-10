package org.example.io_file_write_read;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class WriterReader {
    public static void main(String[] args) {
        writeText();
        readText();
    }

    private static void writeText() {
        String test = "ABC 123!!!"; // Эту строку мы посимвольно запишем в файл

        // Создание экземпляра потока для записи символов как автозакрываемый ресурс.
        try (FileWriter fw = new FileWriter("text111.txt")) {
            // Записываем посимвольно, обращаясь к каждому элементу строки (как к символу)
            for (int i = 0; i < test.length(); i++) {
                System.out.println("test.charAt(i) : " + test.charAt(i));
                fw.write(test.charAt(i));
            }
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    private static void readText() {
        try (FileReader fr = new FileReader("text111.txt")) {
            // Переменная для хранения строки
            StringBuilder sb = new StringBuilder();
            int code;
            // Читаем посимвольно пока код считанного символа не станет равным -1
            while ((code = fr.read()) != -1) {
                // Вызов Character.toChars() преобразует int в char
                System.out.println("Character.toChars(code) : " + code);
                sb.append(Character.toChars(code));
            }
            System.out.println(sb.toString());

        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
