package org.example.impl;

public class MyClass {
    public static int staticField = 10;

    public static void staticMethod() {
        System.out.println("This is a static method");
    }

    public static void main(String[] args) {
        // Создаем экземпляр класса
        MyClass myObject = new MyClass();

        // Обращение к статическому полю через экземпляр класса
        System.out.println(myObject.staticField);  // Выводит: 10

        // Обращение к статическому методу через экземпляр класса
        myObject.staticMethod();  // Выводит: This is a static method


    }
}
