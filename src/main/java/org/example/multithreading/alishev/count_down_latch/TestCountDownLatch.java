package org.example.multithreading.alishev.count_down_latch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/*
В этом примере ждет поток main, а отсчет ведется в потоках.
 */
public class TestCountDownLatch {
    public static final int howManyLatches = 3;
    public static final int howManyThreads = 3;
    // в нашем варианте количество потоков должно быть равным или большим количества защелок, иначе программа не завершится, так как одна защелка не отсчитается.
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch CDLatch = new CountDownLatch(howManyLatches); // аргумент в скобках означает, сколько раз мы должны вызвать метод countDown(), чтобы защелка стала равной 0 и await() больше не ждал.

        ExecutorService executorService = Executors.newFixedThreadPool(howManyThreads);
        // назначаем всем потокам задания вида "new Processor(CDLatch)". Задачи должны быть Runnable.
        for (int i = 0; i < howManyThreads; i++) {
            executorService.submit(new Processor(CDLatch));
        }
        long startTime = System.currentTimeMillis(); //засекаем начало выполнения заданий
        executorService.shutdown();

        CDLatch.await(); // поток main будет ждать, пока наша защелка откроется, т.е. когда она станет равной 0. Типа метода join.
        System.out.println("Latch has been opened, main thread is proceeding");
        long stopTime = System.currentTimeMillis();//фиксируем окончание выполнения заданий
        System.out.println("How much time : " + (stopTime-startTime));
    }
}

class Processor implements Runnable {
    private final CountDownLatch countDownLatch;
    public Processor(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("running thread : " + Thread.currentThread().getName());
        countDownLatch.countDown(); // метод, который декрементирует переменную countDownLatch на единицу (типа как писали count--).
    }
}

//после вызова метода shutdown все потоки одновременно ждали 3 секунды и примерно в один же момент отсчитали защелку назад вызовом countDown(), поэтому общее время примерно равно 3 секундам.