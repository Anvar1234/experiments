package org.example.impl;

public class ArrayLength {
    public static void main(String[] args) {
        int[] arr = new int[10];
        System.out.println("length = " + arr.length);
        for(int i : arr){
            System.out.print(" " + i); //все элементы инициализированы нулями 0.

        }
        
    }
}
