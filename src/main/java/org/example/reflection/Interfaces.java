package org.example.reflection;

import java.util.ArrayList;

public class Interfaces {
    public static void main(String[] args) {
        Class<?> cls = ArrayList.class;
        Class<?>[] ifs = cls.getInterfaces();

        System.out.println("List of interfaces\n");
        for (Class<?> ifc : ifs) {
            System.out.println(ifc.getName());
        }
    }
}
