package org.example.lambdas.ex3;

public class Main {
    public static void main(String[] args) {
        // Используем лямбда-выражение
        TriFunction<String, Object, Object, String> formatterLambda =
                (s, o1, o2) -> String.format(s, o1, o2);

        // Пример использования
        String result = formatterLambda.apply("Привет, %s! У тебя %d новых сообщений.", "Alice", 5);
        System.out.println(result); // Вывод: Привет, Alice! У тебя 5 новых сообщений.
    }
}