package org.example.leetcode;

/**
 * 69. Sqrt(x)
 * Дано неотрицательное целое число x, возврат квадратный корень из x округлён до ближайшего целого числа.
 * Возвращённое целое число должно быть неотрицательный также.
 * <p>
 * Ты не должен использовать любую встроенную функцию или оператор экспоненты.
 * Например, не использовать pow(x, 0.5) в c++ или x ** 0.5 в питоне.
 * <p>
 * Пример 1:
 * Вход: x = 4
 * Выход: 2
 * Пояснение: Квадратный корень из 4 равен 2, поэтому возвращаем 2.
 * <p>
 * Пример 2:
 * Вход: x = 8
 * Выход: 2
 * Пояснение: Квадратный корень из 8 равен 2,82842..., и поскольку мы округляем его до ближайшего целого числа, возвращается 2.
 * <p>
 * Пример 3:
 * Вход: 2147395600
 * Выход:
 */
public class Task11Sqrt {
    public static void main(String[] args) {
        System.out.println(mySqrt(3)); //1551, 2_147_395_600, 3,
    }

    /**
     * Способ 1: Это решение подходит только для небольших чисел, а для числа типа 2_147_395_600 не подойдет, что-то связанное
     * с переполнением типа данных.
     */
//    public static int mySqrt(int x) {
//        int middleRes = 0;
//        int result = 0;
//        while (middleRes * middleRes <= x){
//            result = middleRes;
//            middleRes += 1;
//        }
//        return result;
//    }
    public static int mySqrt(int x) {
        int rankCount = 0;
        int copyX = x;
        //поиск количества разрядов числа.
        while (copyX != 0) {
            copyX /= 10;
            rankCount++;
        }
        StringBuilder rank = new StringBuilder();
        rank.append("1");
        rankCount /= 2;
        for (int i = 0; i < rankCount; i++) {
            rank.append("0");
        }
        int intRank = Integer.parseInt(rank.toString());

        //Получаем стартовое число, которое предположительно корень из вводимого числа. Принимаем его как число,
        // которое имеет половину разрядов первоначального числа.
        double result = x / intRank; //double для того, чтобы можно было попасть в интервал -1<x<1.
        //реализуем вавилонский метод поиска квадратного корня.
        while ((x - result * result) <= -1 || (x - result * result) >= 1){
            result = (result + x / result) / 2;
        }
        return (int) result;
    }
}
