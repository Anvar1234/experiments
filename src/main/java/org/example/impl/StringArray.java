package org.example.impl;

public class StringArray {
    public static void main(String[] args) {
        String[] strArray = null;
        for(String str : strArray){
            System.out.println(str);
        }
        StringBuilder sb = new StringBuilder("Пример строки");

        int index = sb.indexOf("Пример"); // Проверяем, содержит ли StringBuilder строку "им"

        if (index != -1) {
            System.out.println("Строка содержит символы 'им'");
        } else {
            System.out.println("Строка не содержит символы 'им'");
        }

    }
    
}
