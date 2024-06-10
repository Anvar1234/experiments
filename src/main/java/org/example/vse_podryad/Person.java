package org.example.vse_podryad;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        if (age < 0) {
            System.out.println("Возраст не может быть отрицательным.");
            return; // Ранний выход из конструктора
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}