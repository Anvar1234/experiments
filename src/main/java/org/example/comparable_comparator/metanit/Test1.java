package org.example.comparable_comparator.metanit;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.TreeSet;

public class Test1 {
    public static void main(String[] args) {
        Comparator<Person> personComparator = new PersonNameComparator()
                                              .thenComparing(new PersonAgeComparator());
        TreeSet<Person> people = new TreeSet<Person>(personComparator);
        people.add(new Person("Tom", 23));
        people.add(new Person("Nick", 34));
        people.add(new Person("Alice", 10));
        people.add(new Person("Bill", 14));
        people.add(new Person("Tom", 12));

        for (Person p : people) {
            System.out.println(p.getName() + " " + p.getAge());
        }
    }
}

class Person {

    private String name;
    private int age;

    public Person(String n, int a) {

        name = n;
        age = a;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }
}

class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class PersonAgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
