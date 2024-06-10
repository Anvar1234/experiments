package org.example.impl;

import java.util.*;

public class IteratorExp {
    public static void main(String[] args) {

        Integer[] array = new Integer[] {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};

        LinkedList<Integer> list = new LinkedList<>();

        Collections.addAll(list, array);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        for (Integer integer: list) {
            System.out.println(integer);
        }

        Map<String, Integer> integerMap = new HashMap<>();
        Iterator myiterator = integerMap.entrySet().iterator();


    }
}
