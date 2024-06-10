package org.example.from18sem5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Task1 {
    private static final Map<Character, Character> BRACKETS = Map.of('(', ')', '[', ']');

    public static void main(String[] args) {
        String inputStringLine1 = "(a[ss]-)3";
        String inputStringLine2 = "([)]";
        String inputStringLine3 = "[";
        String inputStringLine4 = ")";

        System.out.println("Checked stringline : " + checkBrackets(inputStringLine1));
    }

    public static boolean checkBrackets(String inputLine) {
        Deque<Character> stringDeque = new ArrayDeque<>();
        for (int i = 0; i < inputLine.length(); i++) {
            char current = inputLine.charAt(i);
            System.out.println("current : " + current);
            if(!BRACKETS.containsKey(current) && !BRACKETS.containsValue(current)) continue;
            if (BRACKETS.containsKey(current)) { //если текущий символ - открывающая скобка (ключ)
                stringDeque.add(current); //добавляем в стек
            } else if (BRACKETS.containsValue(current) && !stringDeque.isEmpty()) { //иначе, если попалась закрывающая скобка и стек не пуст
                Character lastBracketInTheStack = stringDeque.pollLast();
                System.out.println("lastBracketInTheStack : " + lastBracketInTheStack);
                if (!BRACKETS.get(lastBracketInTheStack).equals(current)) { //проверяем, что по ключу "последний символ в стеке" - такая же закрывающая скобка является значением.
                    return false;
                }
            } else return false;
        }
        return stringDeque.isEmpty();
    }
}
