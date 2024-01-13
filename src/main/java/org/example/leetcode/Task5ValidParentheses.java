package org.example.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Дана строка s содержит только символы '(', ')', '{', '}', '[' и ']', определить, является ли входная строка валидной.
 * <p>
 * Строка ввода действительна, если:
 * Открытые скобки должны быть закрыты одним и тем же типом скобок.
 * Открытые скобки должны быть закрыты в правильном порядке.
 * Каждая закрывающая скоба имеет соответствующий открывающую скобку того же типа.
 * <p>
 * Example 1:
 * Input: s = "()"
 * Output: true
 * <p>
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * <p>
 * Example 3:
 * Input: s = "(]"
 * Output: false
 */
public class Task5ValidParentheses {

    static final Map<Character, Character> bracketsMap = new HashMap<>();

    static {
        bracketsMap.put(')', '(');
        bracketsMap.put(']', '[');
        bracketsMap.put('}', '{');
    }

    public static void main(String[] args) {
        Task5ValidParentheses task5ValidParentheses = new Task5ValidParentheses();
        System.out.println(task5ValidParentheses.isValid("( [])"));
    }

    public boolean isValid(String s) {
        s = s.replaceAll(" ", "").trim();
        Deque<Character> stackBrackects = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            if (bracketsMap.containsValue(c)) {
                stackBrackects.push(c);
            } else if (bracketsMap.containsKey(c)) {
                if (stackBrackects.isEmpty() || stackBrackects.pop() != bracketsMap.get(c)) return false;
            }
        }
        return stackBrackects.isEmpty();
    }
}



