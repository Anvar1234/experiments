package org.example.stream_api.stream_init;
import java.util.Spliterator;
import java.util.function.Supplier;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CustomSpliteratorExample {
    public static void main(String[] args) {
        // Поставщик сплитератора
        Supplier<Spliterator<String>> spliteratorSupplier = () -> new CustomSpliterator();

        // Создаем поток из поставщика сплитератора (непараллельный)
        Stream<String> stream = StreamSupport.stream(spliteratorSupplier, Spliterator.ORDERED, false);

        // Используем поток
        stream.forEach(System.out::println);
    }
}

// Пример собственного сплитератора
class CustomSpliterator implements Spliterator<String> {
    private final String[] data = {"apple", "banana", "cherry"};
    private int index = 0;

    @Override
    public boolean tryAdvance(java.util.function.Consumer<? super String> action) {
        if (index < data.length) {
            action.accept(data[index++]);
            return true;
        }
        return false;
    }

    @Override
    public Spliterator<String> trySplit() {
        return null; // Простая реализация без разбиения
    }

    @Override
    public long estimateSize() {
        return data.length - index;
    }

    @Override
    public int characteristics() {
        return Spliterator.ORDERED | Spliterator.SIZED;
    }
}
