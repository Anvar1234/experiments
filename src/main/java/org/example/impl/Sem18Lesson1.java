package org.example.impl;

//Дан массив двоичных чисел, например [1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 1],
//вывести максимальное кол-во подряд идущих 1.
public class Sem18Lesson1 {

    public static int getMaxCount(int[] argArray) {
        int maxCount = 0;
        int count = 0;
        for (int elem : argArray) {
            if (elem == 1) count++;
            else count = 0;
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }
}
