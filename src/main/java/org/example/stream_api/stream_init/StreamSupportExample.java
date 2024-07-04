package org.example.stream_api.stream_init;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class StreamSupportExample {
    public static void main(String[] args) {
        List<String> list = List.of("apple", "banana", "cherry");

        // Получаем сплитератор из списка
        Spliterator<String> spliterator = list.spliterator();

        // Создаем поток из сплитератора (непараллельный)
        Stream<String> stream = StreamSupport.stream(spliterator, false);

        // Используем поток
        stream.forEach(System.out::println);

    }
}
