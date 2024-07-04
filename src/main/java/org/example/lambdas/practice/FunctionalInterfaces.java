package org.example.lambdas.practice;

import java.util.function.UnaryOperator;

public class FunctionalInterfaces {

    public static void main(String[] args) {
        // Функциональный интерфейс UnaryOperator<T>
        // Задача. Реализовать лямбда-выражение, удваивающее указанное число.
        // 1. Объявить ссылку на UnaryOperator<T> и присвоить ей лямбда-выражение
        UnaryOperator<Double> number = (n) -> n*2;

        // 2. Вызвать метод number.apply()
        Double t = number.apply(2.8);
        System.out.println("t = " + t); // t = 5.6
    }
}