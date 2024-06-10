package org.example.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ArrayAsList {
    public static void main(String[] args) {
        Integer[] diceRoll = new Integer[6];
        System.out.println(Arrays.toString(diceRoll));
        //using aslist() method
        List<Integer> diceRollList = Arrays.asList(diceRoll);
        System.out.println(diceRollList);
        // using getters and setters to randomly access the list
        diceRollList.set(5, 6);
        diceRollList.set(0, 1);
        System.out.println(diceRollList.get(5));
        System.out.println(diceRollList.get(1));

        System.out.println(diceRollList);
//        diceRollList.remove(1); // исключение
//        diceRollList.add(7); // исключение

//        List integerArrayList = new ArrayList<>(List.of(diceRoll));
////        integerArrayList.add(2);
//        System.out.println(integerArrayList);
        ArrayList<Integer> integerArrayList1 = new ArrayList<>(Arrays.asList(diceRoll));
        integerArrayList1.add(2);
        integerArrayList1.add(100);
        System.out.println(integerArrayList1);
        integerArrayList1.remove(1);
        System.out.println(integerArrayList1);
        diceRollList.set(0, 55);

        System.out.println(diceRollList);
        System.out.println(Arrays.toString(diceRoll));

    }
}