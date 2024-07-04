package org.example.lambdas.mytest;

import java.util.LinkedList;
import java.util.List;

public class TestClass {
    public static void main(String[] args) {
        List<String> strings = new LinkedList<>();
        strings.add("мама");
        strings.add("мыла");
        strings.add("раму");

        strings.forEach(System.out::println);


    }
    public void smth(){
        double d = 2.0;
    }
}
