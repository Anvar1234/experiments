package org.example.lambdas.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Задачи из телеги: https://telegra.ph/Ssylka-na-metod-02-12.
 */
public class Practice {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();

        integers.add(5);
        integers.add(1);
        integers.add(-2);
        integers.add(6);

//        integers.forEach(System.out::println);

        integers.forEach(Practice::myPrintln);
    }

    public static void myPrintln(Object object){
        System.out.println(object);
    }
}
