package org.example.multithreading.alishev.prerivanie_potokov;

import java.util.Random;

public class TestInterruptedException {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                //задача - чтобы поток работал долго, чтобы мы его могли прервать. Поэтому реализуем вычисление синуса случайного числа 1 млрд раз.
                for (int i = 0; i < 1_000_000_000; i++) { //ПОПРОБОВАТЬ РАЗДЕЛИТЬ ВЫЧИСЛЕНИЯ МЕЖДУ НЕСКОЛЬКИМИ ПОТОКАМИ.
                    Math.sin(random.nextDouble());
                }
            }
        });
        System.out.println("Started thread");

        long startTime = System.currentTimeMillis();

        thread1.start();
        thread1.join();

        long stopTime = System.currentTimeMillis();
        System.out.println("How long time : " + (stopTime - startTime) + " mlls");

        System.out.println("Finished thread");
    }
}
