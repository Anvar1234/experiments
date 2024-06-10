package org.example.sort_tests;

public class ShortTest {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(1);
        stringBuilder.append("11");
        stringBuilder.append(1.0);
        stringBuilder.append("asdas");
        System.out.println("stringBuilder :" + stringBuilder);
        System.out.println("stringBuilder.length() : " + stringBuilder.length());
        System.out.println("delete : " + stringBuilder.delete(0, stringBuilder.length()));
        System.out.println("stringBuilder.length() : " + stringBuilder.length());
    }
}
