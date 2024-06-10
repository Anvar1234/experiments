package org.example.jenerics;

import java.util.List;

public class ExampleGeneric<T extends Comparable<T> > {
    public void processGeneric(List<T> list) {
        // Пример: Получение первого элемента списка
        if (!list.isEmpty()) {
            T firstElement = list.get(0);
            System.out.println("Первый элемент списка: " + firstElement);
        }

        // Пример: Вызов метода, специфичного для типа T (если такой метод существует)
        // Этот пример будет работать, если тип T имеет метод toString()
        for (T obj : list) {
            String stringValue = obj.toString();
            System.out.println("Строковое представление элемента: " + stringValue);
        }

        // Пример: Выполнение операций с типом T
        // Например, сложение или сравнение элементов
        if (list.size() >= 2) {
            T element1 = list.get(0);
            T element2 = list.get(1);
            // Предположим, что тип T поддерживает операцию сравнения
            int comparisonResult = element1.compareTo(element2);
            System.out.println("Результат сравнения первых двух элементов: " + comparisonResult);
        }
    }

    public static void main(String[] args) {
        ExampleGeneric<Integer> integerExample = new ExampleGeneric<>();
        ExampleGeneric<String> stringExample = new ExampleGeneric<>();

        List<Integer> integerList = List.of(1, 2, 3);
        List<String> stringList = List.of("a", "b", "c");

        System.out.println("Примеры для списка целых чисел:");
        integerExample.processGeneric(integerList);

        System.out.println("\nПримеры для списка строк:");
        stringExample.processGeneric(stringList);
    }
}
