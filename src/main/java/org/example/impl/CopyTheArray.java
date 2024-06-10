package org.example.impl;

public class CopyTheArray {
    public static void main(String[] args) {
        int[] array = {1,0,5,6};
        array = new int[array.length + 1];
        for(int i : array){
            System.out.print(" " + i);
        }
        System.out.println();

        int[] newArray = array;
        for(int i : newArray){
            System.out.print(" " + i);
        }
    }
}
