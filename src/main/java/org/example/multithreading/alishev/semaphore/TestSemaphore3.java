package org.example.multithreading.alishev.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/*
Пример с соединением к серверу. С семафором.
*/
public class TestSemaphore3 {
    private static int threadsCount = 200;
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(threadsCount);

        Connection2 connection = Connection2.getConnection();

        for (int i = 0; i < threadsCount; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        long startTime = System.currentTimeMillis();

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        long stopTime = System.currentTimeMillis();
        System.out.println("Понадобилось времени : " + (stopTime - startTime));
    }
}

//Класс-пример паттерна Singleton - только один объект класса Connection будет создан, и только он будет использоваться.
class Connection2 { //этот класс как бы представляет собой соединение к серверу, это ценный ресурс, и мы хотим разделить его между потоками.
    private static Connection2 connection = new Connection2();
    private int connectionsCount;
    private Semaphore semaphore = new Semaphore(10); //как раз ограничиваем количество одновременно возможных потоков для доступа к нашему объекту Connection. Говорим, что ребят, можем выдать только 10 разрешений одновременно.

    private Connection2() {
    }

    public static Connection2 getConnection() {
        return connection;
    }

    //ВАЖНО: Алишев поясняет, зачем обернул метод doWork в метод work: потому что освобождать разрешения всегда необходимо в блоке finally. И чтобы не нагромождать, перенесли реализацию работы с семафором в другой метод. Метод release() как раз и возвращает разрешение обратно в пул разрешений, поэтому располагается в блоке finally.
    public void work() throws InterruptedException {
        semaphore.acquire(); //выдаем потоку разрешение на работу.
        try {
            doWork();
        } finally {
            semaphore.release(); //забираем у потока разрешение обратно в блоке finally, поэтому разрешение вернется в пул, даже если в ходе выполнения потоком работы выброситься исключение или возникнет ошибка.
        }
    }

    private void doWork() throws InterruptedException {
        synchronized (this) {
            connectionsCount++;
            System.out.println("connectionsCount : " + connectionsCount);
        }
        Thread.sleep(5000); // симулируем какую-то полезную работу.
        synchronized (this) {
            connectionsCount--;
            System.out.println("Поток : " + Thread.currentThread().getName() + " доделал работу.");
        }
    }
}