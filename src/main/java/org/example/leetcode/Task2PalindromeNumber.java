package org.example.leetcode;

public class Task2PalindromeNumber {
    /**
     * Решить и через строку, и не используя ее.
     * Дано целое число x, возврат true если x является палиндромом, и false иначе.
     * Пример 1:
     * <p>
     * Вход: x = 121
     * Выход: истинный
     * Пояснение: 121 читается как 121 слева направо и справа налево.
     * Пример 2:
     * <p>
     * Вход: x = -121
     * Выход: ложный
     * Пояснение: Слева направо она гласит -121. Справа налево становится 121-. Поэтому это не палиндром.
     * Пример 3:
     * <p>
     * Вход: x = 10
     * Выход: ложный
     * Пояснение: Читает 01 справа налево. Поэтому это не палиндром.
     *
     * @param args
     */

    public static void main(String[] args) {
        Task2PalindromeNumber task2PalindromeNumber = new Task2PalindromeNumber();
        long startTime = System.nanoTime();
        System.out.println(task2PalindromeNumber.isPalindrome(123321));
        long endTime = System.nanoTime();
        long diff = endTime - startTime;
        System.out.println("isPalindrome = " + diff);

        long startTime2 = System.nanoTime();
        System.out.println(task2PalindromeNumber.isStringPalindrome(123321));
        long endTime2 = System.nanoTime();
        long diff2 = endTime2 - startTime2;
        System.out.println("isStringPalindrome = " + diff2);
    }

    //не через строку
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int number2 = x;
        int count = 0;
        while (number2 > 0) {
            number2 /= 10;
            count++;
        }

        int[] result = new int[count];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = x % 10;
            x /= 10;
        }

        //это нужно вынести в отдельный метод.
        int i = 0, j = result.length - 1;
        while (i <= j) {
            if (result[i] == result[j]) {
                i++;
                j--;
            } else return false;
        }

        return true;
    }

    public boolean isStringPalindrome(int x) {
        if(x < 0) return false;
        String strX = Integer.toString(x);
        int i = 0, j = strX.length() - 1;
        while (i <= j){
            if (strX.charAt(i) == strX.charAt(j)) {
                i++;
                j--;
            } else return false;
        }
        return true;
    }

}


