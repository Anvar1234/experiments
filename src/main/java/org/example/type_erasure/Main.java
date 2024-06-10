package org.example.type_erasure;

import java.util.ArrayList;
import java.util.List;

//public class Main {
//
//    private class Cat {
//
//    }
//
//    public static void main(String[] args) {
//
//        List<String> strings = new ArrayList<>();
//        List<Integer> numbers = new ArrayList<>();
//        List<Cat> cats = new ArrayList<>();
//
//        System.out.println("strings.getClass() : " + strings.getClass());
//        System.out.println("numbers.getClass() : " + numbers.getClass());
//        System.out.println("cats.getClass() : " + cats.getClass());
//        System.out.println("strings.getClass() == numbers.getClass()? : " + (strings.getClass() == numbers.getClass()));
//        System.out.println("numbers.getClass() == cats.getClass()? : " + (numbers.getClass() == cats.getClass()));
//
//        List list = new ArrayList<>();
//        list.add("Hello");
//        String item = (String) list.get(0);
//        System.out.println(item);
//
//
//    }
//}




//
//public class Main {
//    public static void main(String[] args) {
//        MyNode mn = new MyNode(5);
//        System.out.println(mn.data);
//        Node n = new Node<>(7);
//        System.out.println(n.data);
//
//        mn.setData(55);
//    }
//}
//class Node<T> {
//    public T data;
//    public Node(T data) {
//        this.data = data;
//        System.out.println("Node.data");
//    }
//    public void setData(T data) {
//        System.out.println("Node.setData");
//        this.data = data;
//    }
//}
//
//class MyNode extends Node<Integer> {
//    public MyNode(Integer data) {
//        super(data);
//        System.out.println("MyNode.data");
//    }
//    public void setData(Integer data) {
//        System.out.println("MyNode.setData");
//        super.setData(data);
//    }
//}


public class Main {
    public static void main(String[] args) {
        Parent<String> p = new Child();
        System.out.println(p.getValue().getClass().getName());  // Вывод: Hello

        Parent p2 = new Parent();
        System.out.println(p2.getValue());  // Вывод: null
    }
}
class Parent<T> {
    public T getValue() {
        return null;
    }
}

class Child extends Parent<String> {
    @Override
    public String getValue() {
        return "Hello";
    }
}
