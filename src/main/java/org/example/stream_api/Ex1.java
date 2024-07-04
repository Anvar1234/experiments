package org.example.stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex1 {
    public static void main(String[] args) {
        List<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
        //Вернуть количество вхождений объекта «a1»
        long count = collection.stream().filter("a1"::equals).count();
        System.out.println("count : " + count);

        //Вернуть первый элемент коллекции или 0, если коллекция пуста
        var obj1 = collection.stream().findFirst().orElse("0");
        System.out.println("obj : " + obj1);

        //Вернуть последний элемент коллекции или «empty», если коллекция пуста
        var obj2 = collection.stream().skip(collection.size() - 1).findAny().orElse("Empty");
        System.out.println("obj : " + obj2);

        //Найти элемент в коллекции равный «a3» или кинуть ошибку
        String obj3 = collection.stream().filter("a3"::equals).findFirst().get();
        System.out.println("obj3 : " + obj3);
        var obj4 = collection.stream().anyMatch("a3"::equals);
        System.out.println("obj4 : " + obj4);

        //Из второй коллекции получить все числа, перечисленные через запятую из всех элементов
        List<String> collection2 = Arrays.asList("1,2,0", "4,5");
        String[] col2 = collection2.stream().flatMap((p) -> Arrays.stream(p.split(","))).toArray(String[]::new);
        System.out.println("col2 : " + Arrays.toString(col2));

        List<String> col3 = collection2.stream().flatMap((p) -> Arrays.stream(p.split(","))).toList();
        System.out.println("col3 : " + col3.get(1));

        //Из второй коллекции получить сумму всех чисел, перечисленных через запятую
        Integer elementsSum = collection2.stream().flatMap((p) -> Arrays.stream(p.split(","))).mapToInt(Integer::parseInt).sum();
        System.out.println("elementsSum : " + elementsSum);

        //Преобразовать в map, сгруппировав по первому символу строки
        List<String> strings = Arrays.asList("a1", "b2", "c3", "a1");
        System.out.println(strings.stream().collect(Collectors.groupingBy((p) -> p.substring(0, 1))));
        System.out.println(strings.stream().collect(Collectors.groupingBy((p) -> p.substring(0, 1), Collectors.mapping((p) -> p.substring(1, 2), Collectors.joining(":")))));


    }

}

