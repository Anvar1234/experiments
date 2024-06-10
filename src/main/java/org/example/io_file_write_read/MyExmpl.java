package org.example.io_file_write_read;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class MyExmpl {
    public static void main(String[] args) throws IOException {
        String fileName = "iowrite_read2.txt";
        File file = new File(fileName);
        System.out.println("Файл создан!");
        String text = "123ABC";
        String text2 = new String("abc123");
        String text3 = "{asd321}";

        writeText(file, text);
        writeText(file, text);
        writeText(file, text2);
        writeText(file, text3);

        System.out.println("Результат: \n" + readText(fileName));
        if (file.delete()) {
            System.out.println("Файл удален, можно заново его создать :) ");
        }

    }

    private static void writeText(File file, String text) {
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            //массив chars в качестве буфера.
            char[] chars = new char[3];
            int index = 0;
            //пока не дойдем до конца строки, считываем посимвольно в буфер.
            for (int i = 0; i < text.length(); i++) {
                chars[index++] = text.charAt(i);
                //если буфер заполнен, то записываем в файл из буфера.
                if (index == chars.length) {
                    fileWriter.write(chars);
                    index = 0;
                }
            }

            //если буфер непустой, то записываем из него index штук значений.
            if (index > 0) {
                fileWriter.write(chars, 0, index);
            }
            //добавим перенос строки.
            fileWriter.append('\n');
            //так как метод ничего не возвращает, то можем обработать исключение прямо на месте.
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }

    //в этом методе пробрасываем исключение выше, так как в случае возникновения исключения IOException
// метод ничего не возвращает, но сигнатура метода требует возвращаемого значения типа String.
    private static String readText(String name) throws IOException {
        try (FileReader fileReader = new FileReader(name)) {
            //массив - буфер для заполнения считанными единичными данными.
            char[] buffer = new char[5];
            //в этот стрингбилдер будем заливать по 5 значений из массива при заполнении буфера.
            StringBuilder stringBuilder = new StringBuilder();
            int count;
            //здесь reas() возвращает кол-во считанных символов, запись единичных данных производится в массив buffer.
            while ((count = fileReader.read(buffer)) != -1) {
                //когда буфер заполнился, начинаем запись в стрингбилдер.
                for (int i = 0; i < count; i++) {
                    stringBuilder.append(buffer[i]);
                }
            }
            return stringBuilder.toString();
        }
    }
}
