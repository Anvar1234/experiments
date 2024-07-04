package org.example.multithreading.alishev.callable_and_future;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallableAndFuture4 {

    public static void main(String[] args) {
        // Создаем пул потоков из двух потоков
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Список для хранения Future объектов
        List<Future<Integer>> futures = new ArrayList<>();

        // Запускаем задачи в цикле
        for (int i = 0; i < 3; i++) {
            Future<Integer> future = executorService.submit(() -> {
                System.out.println("Started");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Finished");
                Random random = new Random();
                int randomValue = random.nextInt(10);
                if(randomValue < 5){
                    throw new Exception("Something happened");
                }
                return randomValue;
            });
            futures.add(future);
        }

        // Завершаем пул потоков
        executorService.shutdown();

        // Обрабатываем результаты выполнения задач
        for (Future<Integer> future : futures) {
            try {
                int result = future.get();
                System.out.println("Result: " + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                Throwable exception = e.getCause();
                System.out.println("Exception: " + exception.getMessage());
            }
        }
    }
}
