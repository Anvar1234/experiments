package org.example.leetcode;

/**
 * Сделать преобразование обратное римскому (Task3).
 * Например:
 * 35 -> XXXV;
 * 122 -> CXXII;
 * 1994 -> MCMXCIV;
 */


public class Task3_1_IntegerToRoman {


    public static void main(String[] args) {
        Task3_1_IntegerToRoman task31IntegerToRoman = new Task3_1_IntegerToRoman();
        System.out.println(task31IntegerToRoman.integerToRoman(122));
    }

    public String integerToRoman(Integer inputNumber) {
        if (inputNumber < 0 || inputNumber > 3999) return "Некорректное число";
        if (inputNumber == 0) return "N";

        StringBuilder stringBuilder = new StringBuilder();
        if (inputNumber >= 1000 && inputNumber <= 3999) {
            int countM = 0;
            countM = inputNumber / 1000;
            inputNumber = inputNumber - countM * 1000;
            while (countM != 0) {
                stringBuilder.append("M");
                countM--;
            }

        }
        if (inputNumber >= 500 && inputNumber < 1000) {
            if (inputNumber / 100 == 9) {
                stringBuilder.append("CM");
                inputNumber = inputNumber - 9 * 100;
            }
            int countD = 0;
            countD = inputNumber / 500;
            inputNumber = inputNumber - countD * 500;
            while (countD != 0) {
                stringBuilder.append("D");
                countD--;
            }
        }
        if (inputNumber >= 100 && inputNumber < 500) {
            if (inputNumber / 100 == 4) {
                stringBuilder.append("CD");
                inputNumber = inputNumber - 4 * 100;
            }
            int countC;
            countC = inputNumber / 100;
            inputNumber = inputNumber - countC * 100;
            while (countC != 0) {
                stringBuilder.append("C");
                countC--;
            }
        }
        if (inputNumber >= 50 && inputNumber < 100) {
            if (inputNumber / 10 == 9) {
                stringBuilder.append("XC");
                inputNumber = inputNumber - 9 * 10;
            }
            int countL;
            countL = inputNumber / 50;
            inputNumber = inputNumber - countL * 50;
            while (countL != 0) {
                stringBuilder.append("L");
                countL--;
            }

        }
        if (inputNumber >= 10 && inputNumber < 50) {
            if (inputNumber / 10 == 4) {
                stringBuilder.append("XL");
                inputNumber = inputNumber - 4 * 10;
            }
            int countX;
            countX = inputNumber / 10;
            inputNumber = inputNumber - countX * 10;
            while (countX != 0) {
                stringBuilder.append("X");
                countX--;
            }

        }
        if (inputNumber >= 5 && inputNumber < 10) {
            if (inputNumber == 9) {
                stringBuilder.append("IX");
                inputNumber = inputNumber - 9;
            }
            int countV;
            countV = inputNumber / 5;
            inputNumber = inputNumber - countV * 5;
            while (countV != 0) {
                stringBuilder.append("V");
                countV--;
            }
        }
        if (inputNumber > 0 && inputNumber < 5) {
            if (inputNumber == 4) {
                stringBuilder.append("IV");
                inputNumber = inputNumber - 4;
            }
            int countX;
            countX = inputNumber;
            while (countX != 0) {
                stringBuilder.append("I");
                countX--;
            }

        }
        return stringBuilder.toString();
    }
}
