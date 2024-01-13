package org.example.leetcode;

/**
 * Напишите функцию, чтобы найти самую длинную общую строку префикса среди массива строк.
 * Если общего префикса нет, верните пустую строку "".
 * <p>
 * Пример 1:
 * Вход: strs = ["flower","flow","flight"]
 * Выход: "fl"
 * <p>
 * Пример 2:
 * Вход: strs = ["dog","racecar","car"]
 * Выход: ""
 * Пояснение: Общего префикса среди входных строк нет.
 */


public class Task4LongestCommonPrefix {
    public static void main(String[] args) {
        Task4LongestCommonPrefix task4LongestCommonPrefix = new Task4LongestCommonPrefix();
        System.out.println(task4LongestCommonPrefix.findLongestCommonPrefix(new String[]{"aa", "af"}));
    }
    //3 способ - сверять индексы. Не надо ничего наращивать и копировать, просто подряд проверять!
    //но сначала куча проверок.

    public String findLongestCommonPrefix(String[] inputStringArray) {
        //проверка на null и пустоту массива в целом.
        if (inputStringArray == null || inputStringArray.length == 0) return "N";

        //проверка на пустоту каждого объекта массива (каждой строки).
        for (int i = 0; i < inputStringArray.length; i++) {
            if (inputStringArray[i].length() == 0) return "NN";
        }

        //проверка на самый короткий элемент (строку) в массиве строк, чтобы получить индекс самого короткого элемента.
        int elemLengths = inputStringArray[0].length();
        int shortLengthIndex = 0;
        for (int i = 1; i < inputStringArray.length; i++) {
            if (inputStringArray[i].length() < elemLengths) {
                elemLengths = inputStringArray[i].length();
                shortLengthIndex = i;
            }
        }
        System.out.printf("Самая маленькая длина: %s, индекс элемента: %s \n", elemLengths, shortLengthIndex);

        //а здесь уже общий случай.
        int index = 0;
        while (index < inputStringArray[shortLengthIndex].length()) {
            for (int i = 1; i < inputStringArray.length; i++) {
                if (inputStringArray[0].charAt(index) != inputStringArray[i].charAt(index)) {
                    return inputStringArray[0].substring(0, index); //правая граница - не включительно.
                }
            }
            index++;
        }
        return inputStringArray[0].substring(0, index); //правая граница - не включительно.
    }


    //1 способ через строку. Не всегда корректно работает, надо тормозить, если уже вторая буква не совпадает. иначе
    // у третьего может совпасть, и это типа релевантный случай. Ну и надо лучше использовать метод
    // startWith() для String.
//        int index2 = 0;
//        String stringResult = String.valueOf(stringsArray[0].charAt(index2));
//
//        while (index2 < stringsArray[0].length() - 1) {
//            System.out.println("stringsArray[0].length() = " + stringsArray[0].length());
//            System.out.println("index2 ДО конката = " + index2);
//            System.out.println("stringResult ДО конката = " + stringResult);
//            stringResult = stringResult.concat(String.valueOf(stringsArray[0].charAt(++index2)));
//            System.out.println("index2 после конката = " + index2);
//            System.out.println("stringResult после конката = " + stringResult);
//            if (stringsArray[0].length() <= index2) return stringResult;
//            for (int i = 1; i < stringsArray.length; i++) {
//                if (stringsArray[i].contains(stringResult)) {
////можно оставить строку кода пустой, не писать continue мы просто пройдем дальше.
//                } else return stringResult;
//            }
//        }
//        return stringResult;
//    }


//
    //2 способ через стрингбилдер
//        StringBuilder sbMain = new StringBuilder();
//        StringBuilder sbTemp = new StringBuilder();
//        int index = 0;
//        sbMain.append(stringsArray[0].charAt(index));
//        System.out.println("StringBuilder = " + sbMain);
//
//        //проверка, не закончилась ли первая строка.
//        if (index == stringsArray[0].length()) return sbMain.toString();
//        //сначала проверим по первым буквам, чтобы в случае несовпадения не выполнять код дальше.
//        for (int i = 1; i < stringsArray.length; i++) {
//            if (stringsArray[i].charAt(0) != sbMain.charAt(0)) {
//                return "";
//            } else if (++index < stringsArray[0].length()) {
//                System.out.println("Index1 = " + index);
//                sbMain.append(stringsArray[0].charAt(index));
//                System.out.println("Index2 = " + index);
//            } else return sbMain.toString();
//        }
//
//        while (index < stringsArray[0].length()) {
//            for (int i = 1; i < stringsArray.length; i++) {
//                if (stringsArray[i].contains(sbMain.toString())) {
//                    sbMain.append(stringsArray[0].charAt(++index));
//                } else return sbMain.deleteCharAt(index).toString();
//            }
//        }
//
//        System.out.println("sbMain = "+sbMain);
//        return sbMain.toString();
}


