package org.example.stream_api.stream_init;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Raznoe {
    //    public static void main(String[] args) {
//        Stream.iterate(new StringBuilder("a"), sb -> {
//                    sb.append("a");
//                    return sb;
//                })
//                .limit(5)
//                .forEach(System.out::println);
//        IntStream.of()
//    }
//    public static void main(String[] args) {
//        Stream.iterate(new StringBuilder("a"), sb -> new StringBuilder(sb).append("a"))
//                .limit(5)
//                .forEach(System.out::println);
//    }
//}
    public static void main(String[] args) {
        for (Integer i : List.of(1, 2, 3)) {
            System.out.print(i);
            System.out.print(i);
            System.out.print(i);
        }

        System.out.println();

        List.of(1, 2, 3)
                .stream()
                .peek(System.out::print)
                .peek(System.out::print)
                .forEach(System.out::print);

        Function<Integer, Integer> function = o -> {
            System.out.println(o);
            return o;
        };

        System.out.println(Optional.of(1)
                .map(function)); //выведет '1' в консоль

        System.out.println(Stream.of(1)
                .map(function)); //ничего не произойдет - нет терминальной операции

        float[] arrFloat = {11f, 2f, 4f};
        Stream<Float> floatStream = IntStream.range(0, arrFloat.length)
                .mapToObj(i -> arrFloat[i]);

        float[] arrFloat2 = {11f, 2f, 4f};
        Stream<Float> floatStream2 = Stream.iterate(0, i -> i < arrFloat2.length, i -> ++i)
                .map(i -> arrFloat2[i]); //получили Stream<Float>


        int[] arrInt = {11, 2, 4};
        IntStream streamInt = Arrays.stream(arrInt);



        System.out.println("equals : " + (Optional.of("Some String").equals(Optional.ofNullable("Some String"))));

        System.out.println("getDeclaredFields()[0] : " + Optional.class.getDeclaredFields()[0]);


        Optional<Integer> optional = Optional.of(5);
        Optional<Integer> optional2 = optional
                .map((x) -> x * 2)
                .map(x->x/3)
                .map(x->x*2);
        System.out.println(optional2);



    }

}