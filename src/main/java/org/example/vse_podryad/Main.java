package org.example.vse_podryad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {3, 2, 5, 1, 4};

        Arrays.sort(numbers);          // [1, 2, 3, 4, 5]
        System.out.println("numbers all" + Arrays.toString(numbers));
        int[] numbers2 = {3, 2, 5, 1, 4};
        Arrays.sort(numbers2, 0, 4);    // [1, 2, 3, 5, 4]
        System.out.println("numbers index" + Arrays.toString(numbers2));
        //----------------------------------

        // Создание списка из массива
        Integer[] array = {1, 2, 3};
        List<Integer> list = Arrays.asList(array);

        // изменение элемента списка
        list.set(0, 10);

        // Вывод изменений
        System.out.println("Массив после изменений в списке:");
        for (Integer num : array) {
            System.out.print(num + " "); // Выведет: 10 2 3
        }
        System.out.println();

        // изменение элемента массива
        array[1] = 20;

        // Вывод изменений
        System.out.println("Список после изменений в массиве:");
        for (Integer num : list) {
            System.out.print(num + " "); // Выведет: 10 20 3
        }
        System.out.println();
        //-----------------------------------------------------

        // Создание массива
        Integer[] array1 = {1, 2, 3};

        // Создание изменяемого списка с использованием ArrayList
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(array1));

        // Вывод списка
        System.out.println("изменяемый список:");
        for (Integer num : arrayList) {
            System.out.print(num + " "); // Выведет: 1 2 3
        }
        System.out.println();

        // изменение списка
        arrayList.set(0, 10);

        // Вывод изменений
        System.out.println("изменяемый список после изменения:");
        for (Integer num : arrayList) {
            System.out.print(num + " "); // Выведет: 10 2 3
        }
        System.out.println();
        //-----------------------------------------
        List<String> names = new ArrayList<String>() {{
            add("John");
            add("Alice");
            add("Bob");
        }};

        // Выводим содержимое списка
        System.out.println("Список имен: " + names);

        List objects = new ArrayList<>();
        objects.add("String");
        objects.add('c');
        objects.add(1);
        objects.add(null);
        System.out.println("List objects : " + objects);


        Integer count = 9;
        Integer count2 = Integer.valueOf("10");
        Integer sum = count + count2;
        System.out.println("sum : " + sum);


        Person person = new Person("1", -5);
        System.out.printf("name : %s & age : %s ", person.getName(), person.getAge());
    }
}
