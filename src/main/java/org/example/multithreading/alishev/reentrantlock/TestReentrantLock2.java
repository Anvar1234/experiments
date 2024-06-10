package org.example.multithreading.alishev.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReentrantLock2 {
    public static void main(String[] args) throws InterruptedException {
        Task2 task2 = new Task2();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                task2.firstThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                task2.secondThread();
            }
        });

        //замерим время2:
        long startTime2 = System.currentTimeMillis();
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        task2.showCounter();

        long stopTime2 = System.currentTimeMillis();
        System.out.println("how much time : " + (stopTime2 - startTime2));
    }
}

class Task2 {
    private int counter;
    private Lock lock = new ReentrantLock();

    private void increment() {
        for (int i = 0; i < 10000; i++) {
            counter++;
        }
    }
    public void firstThread() {
        lock.lock(); // только один поток может вызвать метод lock(). Если какой-то поток вырывается вперед и первым вызывает этот lock(), то все остальные потоки ждут, пока не будет вызван метод unlock().
        increment();
        lock.unlock();
    }
    public void secondThread() {
        lock.lock();
        increment();
        lock.unlock();
    }
    public void showCounter() {
        System.out.println("counter : " + counter);
    }
}