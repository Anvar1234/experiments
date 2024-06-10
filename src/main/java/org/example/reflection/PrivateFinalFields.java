package org.example.reflection;

import java.lang.reflect.Field;

class PrivateFinalFields {
    private int i = 1;
    private final String s = "String S";
    private String s2 = "String S2";

    @Override
    public String toString() {
        return "i = " + i + ", " + s + ", " + s2;
    }
}

class ModifyngPrivateFields {
    public static void main(String[] args) throws Exception {
        PrivateFinalFields pf = new PrivateFinalFields();

        Field f = pf.getClass().getDeclaredField("i");
        f.setAccessible(true);
        f.setInt(pf, 47);
        System.out.println("1. " + pf);

        f = pf.getClass().getDeclaredField("s");
        f.setAccessible(true);
        f.set(pf, "MODIFY S");
        System.out.println("2. " + pf);

        f = pf.getClass().getDeclaredField("s2");
        f.setAccessible(true);
        f.set(pf, "MODIFY S2");

        f = pf.getClass().getDeclaredField("i");
        f.setAccessible(true);
        f.setInt(pf, 35);
        System.out.println("3. " + pf);
    }
}