package org.example.lambdas.ex2;
public class SthClass2 {
    public void doSth() {
        SthFunctionalInterface2 f = (s1, s2) -> doSthInternal(s1, s2); //получается, что метод apply() функционального интерфейса внутри себя вызывает внутренний метод doSthInternal() класса SthClass2.
        // Пример вызова метода на объекте f
        f.apply("value1", "value2");
    }

    private void doSthInternal(String sthString1, String sthString2) {
        System.out.println("Internal: " + sthString1 + ", " + sthString2);
    }

    public static void main(String[] args) {
        SthClass2 example = new SthClass2();
        example.doSth();
    }
}
