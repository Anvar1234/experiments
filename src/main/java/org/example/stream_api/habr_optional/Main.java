package org.example.stream_api.habr_optional;
import java.util.Optional;
public class Main {
    public static void main(String[] args) {
        System.out.println("++++++++++++");
        Integer int1 = Optional.of(100)
                .orElse(getDefault()); //этот метод принимает или конкретное значение, или возвращаемый методом результат, но передавать метод в orElse – не надо!
        System.out.println("int1 " + int1);
        //int1 == 100; console output: default logging

        System.out.println("++++++++++++");
        Integer defaultValue = getDefault(); //в этом случае даже в отдельную переменную записали результат выполнения метода getDefault().
        //defaultValue == 0; console output: default logging
        Integer int11 = Optional.of(100)
                .orElse(defaultValue);
        System.out.println("int11 " + int11);
        //int1 == 100; defaultValue == 0

        System.out.println("++++++++++++");
        Integer int2 = Optional.of(100)
                .orElseGet(Main::getDefault); //этот метод принимает Supplier, то есть лямбду (в нашем случае метод референс).
        System.out.println("int2 " + int2);
        //int2 == 100; console output: *empty*

        System.out.println("++++++++++++");
        Integer int3 = (Integer) Optional.empty()
                .orElse(getDefault());
        System.out.println("int3 " + int3);
        //int3 == 0; console output: default logging

        System.out.println("++++++++++++");
        Integer int4 = (Integer) Optional.empty()
                .orElseGet(Main::getDefault);
        System.out.println("int4 " + int4);
        //int4 == 0; console output: default logging
    }
    private static Integer getDefault() {
        System.out.println("default logging");
        return 0;
    }
}
