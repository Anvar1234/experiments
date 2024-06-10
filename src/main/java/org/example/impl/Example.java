package org.example.impl;

import java.util.ArrayList;
import java.util.List;

public class Example<T> {
    private T value;

    public Example(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static void main(String[] args) {
        Example<Integer> example = new Example<>(10);
        Integer value = example.getValue(); // Ошибка компиляции
        System.out.println(value);

        List<String> stringList = new ArrayList<>();
        stringList.add("Привет");
        String str = stringList.get(0);
        System.out.println(str);
    }
    public List<T> createList() {
        // Тут компилятор выдаст ошибку, так как информация о T стирается и недоступна во время выполнения
        return new ArrayList<T>();
    }

}