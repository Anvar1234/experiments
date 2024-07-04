package org.example.multithreading;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main started");
        Thread thread11 = new Thread(new MyThread11());
        thread11.start();

        Thread thread22 = new Thread(new MyThread22());
        thread22.start();

        Thread thread33 = new Thread(new MyThread33());
        thread33.start();

        new Thread(new MyThread11()).start();

        new Thread(() -> System.out.println("MyThreadXX")).start();

        try {
            thread33.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Main finished");
    }
}

class MyThread11 extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread11");
    }
}

class MyThread22 implements Runnable {
    @Override
    public void run() {
        System.out.println("MyThread22");
    }
}

class MyThread33 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("***" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
