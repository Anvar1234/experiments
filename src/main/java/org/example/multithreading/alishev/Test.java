package org.example.multithreading.alishev;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.printf("%s started. \n", Thread.currentThread().getName());
//        Thread thread = new Thread(() -> {
//            try {
//                Thread.sleep(1000); // Поток находится в состоянии ожидания
//            } catch (InterruptedException e) {
//                System.out.println("Прервано!");
//            }
//        });
//        thread.start();
//        thread.interrupt(); // Вызываем метод interrupt() для прерывания потока


//        MyThread myThread = new MyThread();
//        myThread.start();
//
//        Scanner scanner = new Scanner(System.in);
//        scanner.nextLine();
//
//        myThread.shutdown();
//        System.out.printf("%s finished... \n", Thread.currentThread().getName());



        Thread thread2 = new Thread(new MyThread2(), "MyThread2");
        thread2.start();
        try{
            Thread.sleep(300);
            thread2.interrupt();
            System.out.printf("Thread %s received status to interrupted \n", thread2.getName());
        } catch (InterruptedException e) {
            System.out.println("Мы в catch");
        }
        System.out.printf("%s finished. \n", Thread.currentThread().getName());



//        Thread thread3 = new Thread(new MyThread3(), "MyThread2");
//        thread3.start();
//        try{
//            Thread.sleep(4);
//            thread3.interrupt();
//            System.out.printf("Thread %s received status to interrupted \n", thread3.getName());
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.printf("%s finished. \n", Thread.currentThread().getName());


//        Thread thread4 = new Thread(new MyThread4(), "MyThread2");
//        thread4.start();
//        try {
//            Thread.sleep(300);
//            thread4.interrupt();
//            System.out.printf("Thread %s received status to interrupted \n", thread4.getName());
//        } catch (InterruptedException e) {
//            System.out.println("Мы в catch");
//        }
//        System.out.printf("%s finished. \n", Thread.currentThread().getName());


//        Thread thread5 = new Thread(new MyThread5(), "MyThread5");
//        thread5.start();
//        try {
//            Thread.sleep(300);
//            thread5.interrupt();
//            System.out.printf("Thread %s received status to interrupted \n", thread5.getName());
//        } catch (InterruptedException e) {
//            System.out.println("Мы в catch");
//        }
//        System.out.printf("%s finished. \n", Thread.currentThread().getName());
    }
}

class MyThread extends Thread {
    private volatile boolean running = true;


    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int count = 0;
        while (running) {
            System.out.println("Hello" + count++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }

    public void shutdown() {
        this.running = false;
    }
}

class MyThread2 implements Runnable {

    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int count = 0;
        long before = System.currentTimeMillis();

        //пока поток не имеет статуса прерванного:
        while (!Thread.currentThread().isInterrupted()) {
            //выводим на консоль:
            System.out.println("Hello " + count++);
            try {
                //затем усыпляем поток:
                Thread.sleep(100);
                System.out.println("Поток спит");
                //если в момент вызова sleep наш поток имеет статус прерванного,
                // то выбросится InterruptedException
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " has been interrupted");
                System.out.println(Thread.currentThread().isInterrupted());    // false
                // повторно сбрасываем состояние, и в while уже не зайдем.
                Thread.currentThread().interrupt();
            }
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());

        long after = System.currentTimeMillis();
        System.out.println("Programm took " + (after - before) + " ms to run");
    }
}

class MyThread3 implements Runnable {

    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int count = 0;
        //пока поток не имеет статуса прерванного:
        while (!Thread.currentThread().isInterrupted()) {
            //выводим на консоль:
            System.out.println("Hello" + count++);
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}

class MyThread4 implements Runnable {

    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int count = 0;

        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Hello" + count++);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " has been interrupted");

                break;  // выход из цикла
            }
        }
        System.out.printf("%s finished... \n", Thread.currentThread().getName());
    }
}

class MyThread5 implements Runnable {

    @Override
    public void run() {
        System.out.printf("%s started... \n", Thread.currentThread().getName());
        int count = 0;
        try {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Hello" + count++);
                Thread.sleep(50);
            }
            System.out.printf("%s finished... \n", Thread.currentThread().getName());
        } catch(InterruptedException e){
            System.out.println(Thread.currentThread().getName() + " has been interrupted");
        }
    }
}