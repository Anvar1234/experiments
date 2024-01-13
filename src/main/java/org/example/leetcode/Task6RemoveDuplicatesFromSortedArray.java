package org.example.leetcode;

/**
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique
 * element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 *
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present
 * in nums initially. The remaining elements of nums are not important as well as the size of nums.
 *
 * Return k.
 *
 * Custom Judge:
 * The judge will test your solution with the following code:
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 * int k = removeDuplicates(nums); // Calls your implementation
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 *
 * If all assertions pass, then your solution will be accepted.
 *
 * Example 1:
 * Input: nums = [1,1,2]
 * Output: 2, nums = [1,2,_]
 * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 *
 * Example 2:
 * Input: nums = [0,0,1,1,1,2,2,3,3,4]
 * Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
 * Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 */
public class Task6RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        Task6RemoveDuplicatesFromSortedArray task6RemoveDuplicatesFromSortedArray = new Task6RemoveDuplicatesFromSortedArray();
        System.out.println(task6RemoveDuplicatesFromSortedArray.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    public int removeDuplicates(int[] nums) {
        int[] expectedNums = new int[nums.length];
        int index = 0;
        expectedNums[0] = nums[0];
        int countOfExclusive = 1; //первый элемент и так уникальный, его сразу считаем, а в цикле ниже i начинаем уже с 1-го элемента.

        for (int i = 1; i < nums.length; i++) {
            if(expectedNums[index] != nums[i]){
                expectedNums[++index] = nums[i];
                countOfExclusive++;
            }
        }
        //нам нужно было изменить исходный массив, поэтому копируем в него тот, который получился.
        //почему-то через clone() не получается сдать на литкоде. Ora пишет: Во втором методе, после удаления дубликатов в expectedNums,
        // используется метод clone() для создания копии expectedNums, которая присваивается переменной nums.
        // Однако, это не означает, что исходный массив nums будет изменен. При изменении nums, изменения не отразятся
        // на оригинальном массиве переданном в метод. Таким образом, второй метод не изменяет исходный массив nums,
        // а лишь возвращает копию массива expectedNums.

        for (int i = 0; i < nums.length; i++) {
            nums[i] = expectedNums[i];
        }
//       nums = expectedNums.clone();

        //возвращаем кол-во уникальных элементов.
        return  countOfExclusive;
    }
}
