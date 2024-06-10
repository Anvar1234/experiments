package org.example.multithreading.alishev.producer_consumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test3 {

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer pc = new ProducerConsumer();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class ProducerConsumer {
    private Queue<Integer> queue = new LinkedList<>();
    private final int LIMIT = 10;
    private final Object lock = new Object(); // объект, на котором будет происходить синхронизация.

    public void produce() throws InterruptedException {
        int value = 0;
        while (true) {
            synchronized (lock) {
                while (queue.size() == LIMIT) { // почему while а не if?
                    lock.wait(); // вызываем wait именно на объекте, на котором синхронизируем блок кода (synchronized (lock)).
                }
                queue.offer(value++);
                lock.notify(); // вызываем notify на том же объекте, что и wait.
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (queue.size() == 0) { // почему while а не if?
                    lock.wait(); // вызываем wait именно на объекте, на котором синхронизируем блок кода (synchronized (lock)).
                }
                int value = queue.poll();
                System.out.println("value : " + value);
                System.out.println("queue.size() : " + queue.size());
                lock.notify(); // вызываем notify на том же объекте, что и wait.
            }
            Thread.sleep(1000);
        }
    }
}