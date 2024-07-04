package org.example.comparable_comparator;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        String[] strings = {"aman", "suvam", null, "sahil", null};

        System.out.println("До сортировки: " + Arrays.toString(strings));

        Arrays.sort(strings, Comparator.nullsFirst(Comparator.reverseOrder()));

        System.out.println("После сортировки: " + Arrays.toString(strings));
    }
}

