package org.example.multithreading;

public class Test2 {
    public static void main(String[] args) {
        // Для запуска потоков:
        // Можно создать экземпляр класса Thread, передав в его конструктор
        // аргумент - экземпляр своего класса-потока, и вызвать метод start():
        Thread thread2 = new Thread(new MyThread2());
        thread2.start();

        // Но в случае наследования от класса Thread можно сразу создать
        // экземпляр своего класса-потока, и вызвать на нем метод start():
        MyThread2 myThread2 = new MyThread2();
        myThread2.start();

        // В случае, если наш класс-поток MyThread3 реализует интерфейс Runnable,
        // создавать объект класса Thread придется в любом случае, просто на объекте
        // класса MyThread3 вызвать метод start() не получится, так как этот метод определен
        // в классе Thread. А раз наш класс не наследуется от Thread, то
        // вызвать его мы можем только создав объект класса Thread:
        Thread thread3 = new Thread(new MyThread3());
        thread3.start();
        // так не позволит компилятор:
        // MyThread3 myThread3 = new MyThread3();
        // myThread3.start();

        //без объявления переменной типа Thread:
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Привет из потока анонимного класса1");
            }
        }).start();

        //с объявлением переменной типа Thread:
       Thread thread = new Thread(new Runnable() { //без объявления переменной типа Thread:
            @Override
            public void run() {
                System.out.println("Привет из потока анонимного класса2");
            }
        });
       thread.start();

       // А также все это дело можно упростить с помощью
       // лямбда-функции (Runnable - это функциональный интерфейс):
        //без объявления переменной типа Thread:
        new Thread(() -> System.out.println("Привет из потока с лямбдой1")).start();

        //с объявлением переменной типа Thread:
        Thread thread4 = new Thread(() -> System.out.println("Привет из потока с лямбдой2"));
        thread4.start();
    }
}

//Можно наследоваться от класса Thread. Но помним, что наследоваться можно только от одного класса:
class MyThread2 extends Thread {
    @Override
    public void run() {
        System.out.println("Привет из потока MyThread2");
    }
}
//Можно реализовать интерфейс Runnable и реализовать его метод run():
class MyThread3 implements Runnable {
    @Override
    public void run() {
        System.out.println("Привет из потока MyThread3");
    }
}
