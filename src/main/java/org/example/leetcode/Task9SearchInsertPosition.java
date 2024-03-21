package org.example.leetcode;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 * Пример 1:
 * Вход: nums = [ 1,3,5,6 ], цель = 5
 * Вывод: 2
 * <p>
 * Пример 2:
 * Вход: nums = [ 1,3,5,6 ], цель = 2
 * Вывод: 1
 * <p>
 * Пример 3:
 * Вход: nums = [ 1,3,5,6 ], цель = 7
 * Вывод: 4
 */

public class Task9SearchInsertPosition {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        Task9SearchInsertPosition task9SearchInsertPosition = new Task9SearchInsertPosition();
        System.out.println(task9SearchInsertPosition.searchInsert(nums, 2));
    }

    public int searchInsert(int[] nums, int target) {
        int index = 0;
        if (target > nums[nums.length - 1]) {
            index = nums.length;
            return index;
        }
        if (target < nums[0]) {
            index = 0;
            return index;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                index = i;
                return index;
            }
            if (nums[i] > target) {
                index = i;
                return index;
            }

        }
        return index;
    }

}
