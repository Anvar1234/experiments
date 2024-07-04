package org.example.lambdas.ex1;


public class SthClass {
    private String sthField = "%s: %s"; // в оригинальном примере поле не было инициализировано, поэтому было не ясно.

    public void doSthUsingField() {    //1
        //some logic
        SthFunctionalInterface f = (s1, s2) -> sthField.formatted(s1, s2);
        // Пример вызова метода функционального интерфейса на объекте f
        String result = f.apply("field1", "field2");
        System.out.println(result);
        //some logic
    }

    // В этом методе переменная strVar объявляется и инициализируется внутри метода. Она явно содержит строку с двумя заполнителями %s, %s, что делает её использование в лямбда-выражении понятным и очевидным.
    public void doSthWithoutField() {    //2
        //some logic
        String strVar = "%s: %s";
        SthFunctionalInterface f = (s1, s2) -> strVar.formatted(s1, s2);
        // Пример вызова метода функционального интерфейса на объекте f
        String result = f.apply("value3", "value4");
        System.out.println(result);
        //some logic
    }

    // В этом методе strParam передаётся в качестве параметра метода и используется внутри лямбда-выражения. Предполагается, что вызывающий метод код передаст строку с двумя заполнителями %s, %s в strParam.
    public void doSthUsingParam(String strParam) {    //3
        //some logic
        SthFunctionalInterface f = (s1, s2) -> strParam.formatted(s1, s2);
        // Пример вызова метода функционального интерфейса на объекте f
        String result = f.apply("value5", "value6");
        System.out.println(result);
        //some logic
    }
    //Пример вызова методов:
    public static void main(String[] args) {
        SthClass example = new SthClass();
        example.doSthUsingField();
        example.doSthWithoutField();
        example.doSthUsingParam("%s: %s");
    }
}
