package org.example.multithreading.alishev.reentrantlock;

public class TestReentrantLock {
    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.firstThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                task.secondThread();
            }
        });
        //замерим время:
        long startTime = System.currentTimeMillis();
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        task.showCounter();

        long stopTime = System.currentTimeMillis();
        System.out.println("how much time : " + (stopTime - startTime));
    }
}

class Task {
    private int counter;

    private void increment() {
        for (int i = 0; i < 10000; i++) { //не всегда результат будет 20000. И volatile не поможет, птму что потоки пишут в одну переменную (а не "один пишет, а другой читает" как того требует условие применения volatile) и возникает race condition. Ранее такую ситуацию мы решали с помощью synchronized.
            counter++;
        }
    }

    public void firstThread() {
        increment();
    }

    public void secondThread() {
        increment();
    }

    public void showCounter() {
        System.out.println("counter : " + counter);
    }
}
