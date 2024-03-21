package org.example.leetcode;

/**
 * 66. Plus One
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 * <p>
 * Increment the large integer by one and return the resulting array of digits.
 * <p>
 * <p>
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 * <p>
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 * <p>
 * Example 3:
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 */
public class Task10PlusOne {

    public static void main(String[] args) {
        int[] digits = {9};
        Task10PlusOne task10PlusOne = new Task10PlusOne();
        int[] newDigits = task10PlusOne.plusOne(digits);
        System.out.println("Массив из main = ");
        for (int el : newDigits) {
            System.out.print(" " + el);
        }

    }

    public int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        }

        int index = digits.length - 1;

        while (index >= 0 && digits[index] == 9) {
            digits[index] = 0;
            index--;
        }
        if (index < 0) {
            digits = new int[digits.length+1];//так не происходит копирования массива! При создании нового массива
            //из того же самого, все значения внутри инициализированы по умолчанию нулями! Здесь нам это и было нужно.
            digits[0] = 1;

            return digits;
        } else {
            digits[index] = digits[index] + 1;
        }
        return digits;
    }

}
