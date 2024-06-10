package org.example.leetcode;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;

/**
 * 67. Add Binary
 * Даны две двоичные строки a и b, возвратить их сумму как двоичную строку.
 * <p>
 * Пример 1:
 * Вход: a = "11", b = "1"
 * Выход: "100"
 * <p>
 * Пример 2:
 * Вход: a = "1010", b = "1011"
 * Выход: "10101"
 * <p>
 * Ограничения:
 * 1 <= a.length, b.length <= 104
 * a и b состоять только из '0' или '1' персонажи.
 * Каждая строка не содержит ведущих нулей, за исключением самого нуля.
 */
public class Task12AddBinary {
    public static void main(String[] args) {
        String a = "1";
        String b = "111";
        System.out.println(addBinary(a, b));
    }

    /**
     * Способ 1. С помощью стандартных библиотек Java.
     */
//    public static String addBinary(String a, String b) {
//        BigInteger aInt = new BigInteger(a,2);
//        BigInteger bInt = new BigInteger(b,2);
//        BigInteger res = aInt.add(bInt);
//        return res.toString(2);
//    }

    /**
     * Способ 2. С помощью brute force (по-тупому, короч).
     */
//    public static String addBinary(String a, String b) {
//        String[] arrayA = a.split("");
//        String[] arrayB = b.split("");
//        System.out.println("arrayA" + Arrays.toString(arrayA));
//        System.out.println("arrayB" + Arrays.toString(arrayB));
//        int buffer = 0;
//        StringBuilder result = new StringBuilder();
//        int aIndex = arrayA.length - 1;
//        int bIndex = arrayB.length - 1;
//
//        while (aIndex >= 0 && bIndex >= 0) {
//            System.out.printf("while, aIndex = %s, bIndex = %s \n", aIndex, bIndex);
//            if (arrayA[aIndex].equals("1") && arrayB[bIndex].equals("1")) {
//                System.out.println("if 1");
//                if (buffer == 1) { //буфер продолжает оставаться непустым.
//                    System.out.println("buffer 1");
//                    result.append("1");
//                    aIndex--;
//                    bIndex--;
//                } else {
//                    result.append("0");
//                    buffer = 1;
//                    aIndex--;
//                    bIndex--;
//                }
//            } else if (arrayA[aIndex].equals("1") && arrayB[bIndex].equals("0")) {
//                System.out.println("if 2");
//                if (buffer == 1) { //буфер продолжает оставаться непустым.
//                    System.out.println("buffer 2");
//                    result.append("0");
//                    aIndex--;
//                    bIndex--;
//                } else {
//                    result.append("1");
//                    aIndex--;
//                    bIndex--;
//                }
//            } else if (arrayA[aIndex].equals("0") && arrayB[bIndex].equals("1")) {
//                System.out.println("if 3");
//                if (buffer == 1) { //буфер продолжает оставаться непустым.
//                    System.out.println("buffer 3");
//                    result.append("0");
//                    aIndex--;
//                    bIndex--;
//                } else {
//                    result.append("1");
//                    aIndex--;
//                    bIndex--;
//                }
//            } else if (arrayA[aIndex].equals("0") && arrayB[bIndex].equals("0")) {
//                System.out.println("if 4");
//                if (buffer == 1) {
//                    System.out.println("buffer 4");
//                    result.append("1");
//                    buffer = 0;
//                    aIndex--;
//                    bIndex--;
//                } else {
//                    result.append("0");
//                    aIndex--;
//                    bIndex--;
//                }
//            }
//        }
//
//        if (aIndex >= 0 ) {
//            while (aIndex >= 0) {
//                if (arrayA[aIndex].equals("1")) {
//                    if (buffer == 1) { //буфер продолжает оставаться непустым.
//                        result.append("0");
//                        aIndex--;
//                    } else {
//                        result.append("1");
//                        aIndex--;
//                    }
//                } else if (arrayA[aIndex].equals("0")) {
//                    if (buffer == 1) {
//                        result.append("1");
//                        buffer = 0;
//                        aIndex--;
//                    } else {
//                        result.append("0");
//                        aIndex--;
//                    }
//                }
//            }
//        }
//        if (bIndex >= 0) {
//            while (bIndex >= 0) {
//                if (arrayB[bIndex].equals("1")) {
//                    if (buffer == 1) { //буфер продолжает оставаться непустым.
//                        result.append("0");
//                        bIndex--;
//                    } else {
//                        result.append("1");
//                        bIndex--;
//                    }
//                } else if (arrayB[bIndex].equals("0")) {
//                    if (buffer == 1) {
//                        result.append("1");
//                        buffer = 0;
//                        bIndex--;
//                    } else {
//                        result.append("0");
//                        bIndex--;
//                    }
//                }
//            }
//        }
//        if (buffer == 1) result.append("1");
//        return result.reverse().toString();
//    }

    /**
     * Способ 3. С включением логики, более красиво. Но это не идеальное решение, на литкод есть лаконичное.
     * Понимаем, что комбинации a + b + buffer не бесконечны, и суммы варьируются от 3 до 0, и от суммы зависит значение в
     * результирующей строке (0 или 1) и пуст или нет буфер (0 или 1).
     */
    public static String addBinary(String a, String b) {

        int buffer = 0;
        StringBuilder result = new StringBuilder();
        int aIndex = a.length() - 1;
        int bIndex = b.length() - 1;


        while (aIndex >= 0 && bIndex >= 0) {
            int sum = Integer.parseInt(String.valueOf(a.charAt(aIndex))) +
                    Integer.parseInt(String.valueOf(b.charAt(bIndex))) +
                    buffer;

            if (sum == 3) {
                result.append('1');
                buffer = 1;
                aIndex--;
                bIndex--;
            }
            if (sum == 2) {
                result.append('0');
                buffer = 1;
                aIndex--;
                bIndex--;
            }
            if (sum == 1) {
                result.append('1');
                buffer = 0;
                aIndex--;
                bIndex--;
            }
            if (sum == 0) {
                result.append('0');
                buffer = 0;
                aIndex--;
                bIndex--;
            }
        }
        if (aIndex >= 0) {
            while (aIndex >= 0) {
                int sum = Integer.parseInt(String.valueOf(a.charAt(aIndex))) + buffer;
                if (sum == 2) {
                    result.append('0');
                    buffer = 1;
                    aIndex--;
                }
                if (sum == 1) {
                    result.append('1');
                    buffer = 0;
                    aIndex--;
                }
                if (sum == 0) {
                    result.append('0');
                    buffer = 0;
                    aIndex--;
                }
            }
        }
        if (bIndex >= 0) {
            while (bIndex >= 0) {
                int sum = Integer.parseInt(String.valueOf(b.charAt(bIndex))) + buffer;
                if (sum == 2) {
                    result.append('0');
                    buffer = 1;
                    bIndex--;
                }
                if (sum == 1) {
                    result.append('1');
                    buffer = 0;
                    bIndex--;
                }
                if (sum == 0) {
                    result.append('0');
                    buffer = 0;
                    bIndex--;
                }
            }
        }
        if (buffer == 1) result.append("1");
        return result.reverse().toString();
    }

}
