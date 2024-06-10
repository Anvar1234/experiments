package org.example.reflection;

import java.io.Serializable;
import java.util.Hashtable;

public class ClassDemo1 {
    public static void main(String[] args) {
        int[] array = new int[4];

        printInfo(array.getClass());
        printInfo(Serializable.class);
        printInfo(Integer.class);
        printInfo(double.class);
        Class<?> clazz = Hashtable.class;
       String strCl= clazz.getName();

    }

    private static void printInfo(Class arrayClass) {
        System.out.println("Class name " + arrayClass.getName());
        System.out.println("Is Array? " + arrayClass.isArray());
        System.out.println("Is Interface? " + arrayClass.isInterface());
        System.out.println("Is Primitive? " + arrayClass.isPrimitive());
        System.out.println();
    }
}