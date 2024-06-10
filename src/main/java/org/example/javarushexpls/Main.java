package org.example.javarushexpls;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Number> numberList = new ArrayList<>();
        numberList.add(32L);
        numberList.add(3.4f);
        for(Number n : numberList){
            System.out.println(n.getClass());
        }

        List<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(2);
        List<? extends Number> nums = ints;
//        nums.add(3.14);

        System.out.println("numberList" + numberList);
        System.out.println("ints" + ints);

        Number n = Integer.valueOf(42);
        Collections.copy(numberList, ints);

        System.out.println("numberList" + numberList);
        System.out.println("ints" + ints);


        List<Person> persons = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        List<Manager> managers = new ArrayList<>();

        List<? extends Employee> list1 = employees;
        List<? extends Employee> list2 = managers;
        List<? super Employee> list3 = persons;
        List<? super Employee> list4 = employees;
    }

    public static void processLowerBounded(List<? super Employee> employees) {
//        employees.add(new Person()); //compilation error
        employees.add(new Employee());
        employees.add(new Manager());
        Object employee = employees.get(0);
        if (employee instanceof Employee) {
            Employee myEmployee = (Employee) employee;
        }
//        Employee employee2 = employees.get(0);//compilation error

    }





}
