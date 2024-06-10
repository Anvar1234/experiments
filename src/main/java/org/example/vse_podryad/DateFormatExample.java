package org.example.vse_podryad;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatExample {
    public static void main(String[] args) {
        String dateString = "01.11.1988";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = LocalDate.parse(dateString, formatter);
        System.out.println(localDate);

        // Используем новый шаблон для форматирования даты
        DateTimeFormatter newFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        System.out.println("localDate : " + newFormatter.format(localDate));
    }
}
