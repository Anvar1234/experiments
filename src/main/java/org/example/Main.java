package org.example;

import org.example.impl.MyClass;
import org.example.impl.Sem18Lesson1;
import org.example.impl.ThisWord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//1.
//        ArrayList list = new ArrayList();
//        System.arraycopy();
//
//        // Упаковка (boxing) - преобразование примитивных типов данных в объект-обертку
//        list.add(5); // Упаковка целочисленного значения
//        list.add(3.14); // Упаковка значения типа double
//        list.add(true); // Упаковка значения типа boolean
//
//        // Распаковка (unboxing) - обратное преобразование объекта-обертки в примитивный тип данных
//        int intValue = (Integer) list.get(0); // Распаковка первого элемента списка в целочисленное значение
//        double doubleValue = (Double) list.get(1); // Распаковка второго элемента списка в значение с плавающей точкой
//        boolean booleanValue = (Boolean) list.get(2); // Распаковка третьего элемента списка в булево значение
//
//        System.out.println(intValue); // Вывод распакованного значения
//        System.out.println(doubleValue); // Вывод распакованного значения
//        System.out.println(booleanValue); // Вывод распакованного значения
//        //_____________________________________________________________________________________________
//2.
        int[] array = new int[]{1, 1, 0, 1, 1, 1, 0, 1};
        int maxCount = Sem18Lesson1.getMaxCount(array);
        System.out.println(maxCount);


        ThisWord thisWord = new ThisWord(5);
        thisWord.setAge(25);
        thisWord.name = "Pol";
        thisWord.age = 18;
        System.out.println(thisWord.name + " - " + thisWord.age);

        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(5);
        arrayList.add(7);

        System.out.println(Math.pow(2, 3));

        // Создаем экземпляр класса
        MyClass myObject = new MyClass();

        // Обращение к статическому полю через экземпляр класса
        System.out.println(myObject.staticField);  // Выводит: 10

        // Обращение к статическому методу через экземпляр класса
        myObject.staticMethod();  // Выводит: This is a static method



    }
}