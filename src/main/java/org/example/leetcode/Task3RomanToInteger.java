package org.example.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Римские цифры представлены семью различными символами: I, V, X, L, C, D и M.
 * <p>
 * Символ-Значение
 * I 1
 * V 5
 * X 10
 * L 50
 * С 100
 * D 500
 * М 1000
 * Например, 2 пишется как II в римской цифре только два из них добавлены вместе. 12 пишется как XII, что просто X + II.
 * Номер 27 пишется как XXVII, который XX + V + II.
 * <p>
 * Римские цифры обычно пишутся самыми большими и самыми маленькими слева направо.
 * Однако числительное для четырёх - нет IIII. Вместо этого число четыре записывается как IV.
 * Потому что один перед пятью мы вычитаем его делая четыре. Тот же принцип применим и к числу девять,
 * которое записывается как IX.
 * <p>
 * Существует шесть случаев, когда используется вычитание:
 * I может быть размещена раньше V (5) и X (10) сделать 4 и 9.
 * X может быть размещена раньше L (50) и C (100) сделать 40 и 90.
 * C может быть размещена раньше D (500) и M (1000) сделать 400 и 900.
 * <p>
 * Учитывая римскую цифру, преобразуйте ее в целое число.
 * <p>
 * Пример 1:
 * Вход: s = "III"
 * Выход: 3
 * Пояснение: III = 3.
 * <p>
 * Пример 2:
 * Вход: s = "LVIII"
 * Выход: 58
 * Пояснение: L = 50, V= 5, III = 3.
 * <p>
 * Пример 3:
 * Вход: s = "MCMXCIV"
 * Выход: 1994
 * Пояснение: M = 1000, CM = 900, XC = 90 и IV = 4.
 */


public class Task3RomanToInteger {

    static final Map<String, Integer> mapOfNumbers = new HashMap<>();

    static {
        mapOfNumbers.put("I", 1);
        mapOfNumbers.put("V", 5);
        mapOfNumbers.put("X", 10);
        mapOfNumbers.put("L", 50);
        mapOfNumbers.put("C", 100);
        mapOfNumbers.put("D", 500);
        mapOfNumbers.put("M", 1000);
    }

    public static void main(String[] args) {
        Task3RomanToInteger task3RomanToInteger = new Task3RomanToInteger();
        int result = task3RomanToInteger.romanToInteger("MCMXCIV");
        System.out.println(result);
    }

    public Integer romanToInteger(String inputString) {
        String[] stringsArray = inputString.split("");
        int result = 0;

        for (int i = 0; i < stringsArray.length - 1; i++) {
            //можно через тернарный оператор написать, но будет очень длинно.
            if (mapOfNumbers.get(stringsArray[i]) < mapOfNumbers.get(stringsArray[i + 1])) {
                result -= mapOfNumbers.get(stringsArray[i]);
            } else result += mapOfNumbers.get(stringsArray[i]);
        }
        return result + mapOfNumbers.get(stringsArray[stringsArray.length - 1]);
    }


}
