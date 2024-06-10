package org.example.iteratorANDiterable;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
//        Integer[] array = new Integer[] {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
//
//        ArrayList<Integer> list = new ArrayList<>();
//
//        Collections.addAll(list, array);
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        MyEntity myEntity1 = new MyEntity(3, "Три");
        MyEntity myEntity2 = new MyEntity(2, "два");
        MyEntity myEntity3 = new MyEntity(8, "Восемь");

        MyCollection myCollection = new MyCollection();
        myCollection.add(myEntity1).add(myEntity2).add(myEntity3);

        System.out.println("1-yi raz");
        for(MyEntity m : myCollection){
            System.out.println(m);
        }
        System.out.println("2-oi raz");
        for(MyEntity m : myCollection){
            System.out.println(m);
        }



    }
}
