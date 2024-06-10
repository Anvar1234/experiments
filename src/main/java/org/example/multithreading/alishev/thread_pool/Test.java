package org.example.multithreading.alishev.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        //как пример, можно представить нижеследующее так, что у нас есть 2 работника, и мы им говорим перенести 5 коробок:
        ExecutorService executorService = Executors.newFixedThreadPool(2); // кол-во создаваемых потоков (работников)

        for (int i = 0; i < 5; i++) { //создаем 5 задач (коробки)
            executorService.submit(new Work(i)); // метод, принимающий Runnable объект (где есть метод run), т.е. задачу.
        }
        executorService.shutdown(); // метод, который говорит о том, что нужно начать выполнение переданных ранее в пул заданий,
        // чем-то похож на метод start().
        System.out.println("Все задачи submited");

        try {
            if (executorService.awaitTermination(1, TimeUnit.SECONDS)) {
                System.out.println("Все задачи завершены");
            }
            else {
                System.out.println("Еще не все задачи завершены.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Work implements Runnable {
    private int id;

    public Work(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Work " + id + " complited");
    }
}
