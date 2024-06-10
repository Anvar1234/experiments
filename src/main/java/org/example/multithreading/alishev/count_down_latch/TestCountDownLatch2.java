package org.example.multithreading.alishev.count_down_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/*
В этом примере наоборот: ждут потоки, а отсчет ведется только в одном потоке - в main.
 */
public class TestCountDownLatch2 {
    public static final int howManyLatches = 3;
    public static final int howManyThreads = 2;

    // в этом варианте количество потоков НЕ обязательно должно быть равным или большим количества защелок, так как все защелкт отсчитываются в одном main потоке.
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cDLatch = new CountDownLatch(howManyLatches); // аргумент в скобках означает, сколько раз мы должны вызвать метод countDown(), чтобы защелка стала равной 0 и await() больше не ждал.

        ExecutorService executorService = Executors.newFixedThreadPool(howManyThreads);

        for (int i = 0; i < howManyThreads; i++) {
            executorService.submit(new Processor2(i, cDLatch)); // назначаем всем потокам задания вида "new Processor(id, cDLatch)". Задачи должны быть Runnable.
        }
        long startTime  = System.currentTimeMillis(); //засекаем начало выполнения задачи
        executorService.shutdown(); //говорим, что мы назначили все задачи, можно начинать выполнение.

        for (int i = 0; i < howManyLatches; i++) {
            System.out.println("main сейчас будет спать");
            Thread.sleep(1000);
            cDLatch.countDown();
            System.out.println("main отсчитал");
        }

      long stopTime = System.currentTimeMillis();//фиксируем окончание выполнения заданий
        System.out.println("How much time in main thread : " + (stopTime - startTime));
    }
}

class Processor2 implements Runnable {
    private int id;
    private final CountDownLatch cDLatch;

    public Processor2(int id, CountDownLatch cDLatch) {
        this.id = id;
        this.cDLatch = cDLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            cDLatch.await(); // потоки остановятся здесь и будут ждать открытия защелки.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread with id " + id + " proceeded"); // после открытия защелки потоки выполнят вывод на консоль.
    }
}

// в этом варианте после вызова метода shutdown() все потоки пошли выполнять свои одинаковые задачи, но остановились на вызове метода await(). Ждут до тех пор, пока в потоке main все защелки не отсчитаются.