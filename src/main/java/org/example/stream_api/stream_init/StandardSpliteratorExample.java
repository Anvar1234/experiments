package org.example.stream_api.stream_init;

import java.util.List;
import java.util.Spliterator;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StandardSpliteratorExample {
    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "cherry");

        // Поставщик сплитератора
        Supplier<Spliterator<String>> spliteratorSupplier = list::spliterator;

        // Создаем поток из поставщика сплитератора (непараллельный)
        Stream<String> stream = StreamSupport.stream(spliteratorSupplier, Spliterator.ORDERED, false);

        // Используем поток
        stream.forEach(System.out::println);
    }
}
