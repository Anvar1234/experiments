package org.example.io_file_write_read.mnogochlen.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Utils {

    public static String prompt(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.print(message);
        return sc.nextLine();
    }

    public static boolean checkInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException numberFormatException) {
            System.out.println(numberFormatException.getMessage());
            return false;
        }
        return true;
    }

    public static boolean writeData(Path path, String data) {
        try {
            if (!Files.exists(path)) {
                Files.createFile(path);
            }
            try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {

                bufferedWriter.write(data);
                bufferedWriter.write("\n");
                return true;
            }
        } catch (IOException exept) {
            System.out.println(exept.getMessage());
            return false;
        }
    }

    public static String readData(Path path) throws IOException {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
            StringBuilder stringBuilder = new StringBuilder();
            String s;
            while ((s = bufferedReader.readLine()) != null) {
                stringBuilder.append(s);
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        }
    }
}