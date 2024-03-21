package org.example.leetcode;

/**
 * Дано целочисленное множество nums и целое число val, удалите все случаи val в nums на месте.
 * Порядок элементов может быть изменен. Затем вернитесь количество элементов в nums которые не равны val.
 * <p>
 * Количество элементов в nums, которые не равны val, обозначить как k.
 * Чтобы быть принятым, вам нужно сделать следующие вещи:
 * Все удаления нужно производить на месте в массиве!
 * изменить массив nums такой, что первый k элементы nums содержат элементы, которые не равны val. Остальные элементы nums не важны, как и размер nums.
 * Возврат k.
 */

public class Task7RemoveElement {
    public static void main(String[] args) {
        int[] nums = {0, 1, 15, 1, 5}; //{0, 2, 3, 4, 5} {0, 1, 15, 1, 5}
        System.out.println(removeElement(nums, 1));
        for (int num : nums) {
            System.out.print(" " + num);
        }

    }

    public static int removeElement(int[] nums, int val) {
        //для удаления элемента "на месте" необходимо ввести доп указатель (index) на текущий элемент в обновляемом массиве.
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
