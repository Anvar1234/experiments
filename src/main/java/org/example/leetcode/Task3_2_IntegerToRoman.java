package org.example.leetcode;

/**
 * Второй вариант решения.
 * Сделать преобразование обратное римскому (Task3_1).
 * Например:
 * 35 -> XXXV;
 * 122 -> CXXII;
 * 1994 -> MCMXCIV;
 */


public class Task3_2_IntegerToRoman {
    private final Integer[] INTEGER_VALUES = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private final String[] ROMANS = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};


    public static void main(String[] args) {
        Task3_2_IntegerToRoman task31IntegerToRoman = new Task3_2_IntegerToRoman();
        System.out.println(task31IntegerToRoman.integerToRoman(122));
    }

    public String integerToRoman(Integer inputNumber) {
        if (inputNumber < 0 || inputNumber > 3999) return "Некорректное число";
        if (inputNumber == 0) return "N";

        StringBuilder strResult = new StringBuilder();
        for (int i = 0; i < INTEGER_VALUES.length; i++) {
            while (INTEGER_VALUES[i] <= inputNumber) {
                strResult.append(ROMANS[i]);
                inputNumber -= INTEGER_VALUES[i];
            }
        }
        return strResult.toString();
    }
}
