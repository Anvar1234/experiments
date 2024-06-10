package org.example.from18sem3;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 10, 2, 7);
        Optional<Integer> optionalInteger = list.stream().max(Integer :: compare);
        System.out.println("max : " + optionalInteger.get());

    }
}
