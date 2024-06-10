package org.example.impl;

import java.util.Arrays;

public class JenericMethod {
    public static void main(String[] args) {


        int[] array = {1, 2, 3, 4, 5};

        for (int item : array) {
            item = item * 2;
        }

        System.out.println(Arrays.toString(array));


    }


}





