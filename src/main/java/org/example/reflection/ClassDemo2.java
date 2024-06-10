package org.example.reflection;

import java.io.Serializable;
import java.lang.reflect.Method;

public class ClassDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        int[] array = new int[4];

        printInfo(array.getClass());
        printInfo(Class.forName("java.io.Serializable"));
        printInfo(Integer.class);
        printInfo(Class.forName("java.lang.String"));
        printInfo(double.class);
        Class cl = String.class;
        Method method = cl.getMethod("length");
        System.out.println("method : " + method);
    }


    private static void printInfo(Class arrayClass) {
        System.out.println("Class name " + arrayClass.getName());
        System.out.println("Is Array? " + arrayClass.isArray());
        System.out.println("Is Interface? " + arrayClass.isInterface());
        System.out.println("Is Primitive? " + arrayClass.isPrimitive());
        System.out.println();
    }
}