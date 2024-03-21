package org.example.leetcode;

public class Task1TwoSum {
    /**
     * Дано множество целых чисел nums и целое число target, возврат индексы двух чисел такие, что они складываются target.
     * Вы можете предположить, что каждый вход будет иметь точно одно решение, и вы можете не использовать тот же элемент дважды.
     * Ответ можно вернуть в любом порядке.

     * Пример 1:
     * Вход: nums = [2,7,11,15], цель = 9
     * Выход: [0,1]
     * Пояснение: Потому что nums[0] + nums[1] == 9, мы возвращаемся [0, 1].
     *
     * Пример 2:
     * Вход: nums = [3,2,4], цель = 6
     * Выход: [1,2]
     *
     * Пример 3:
     *
     * Вход: nums = [3,3], цель = 6
     * Выход: [0,1]
     * @param args
     */

    public static void main(String[] args) {
        int[] array = new int[]{2, 7, 7, 11, 15};
        Task1TwoSum task1TwoSum = new Task1TwoSum();
       int[] result = task1TwoSum.twoSum(array, 18);
        System.out.println("Результат: ");
        for (Integer intElem : result) {
            System.out.print(" " + intElem);
        }
    }


    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}
