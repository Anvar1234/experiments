package org.example.multithreading.alishev.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
Пример с соединением к серверу. Без семафора.
*/
public class TestSemaphore2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        Connection connection = Connection.getConnection(); //достаем наш единственный экземпляр Connection.

        for (int i = 0; i < 10; i++) { //всем потокам нарежем задачу сделать doWork().
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        connection.doWork();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        long startTime = System.currentTimeMillis();

        executorService.shutdown(); //говорим что мы закончили нарезку задач и можно начинать их выполнять.
        executorService.awaitTermination(1, TimeUnit.DAYS); // Ожидаем завершения всех нарезанных задач. Метод блокирует текущий поток до тех пор, пока все задачи не завершат выполнение после запроса на завершение работы, или не истечет время ожидания, или текущий поток не будет прерван, в зависимости от того, что произойдет раньше.
        long stopTime = System.currentTimeMillis();
        System.out.println("Понадобилось времени : " + (stopTime - startTime));
    }
}

//Класс-пример паттерна Singleton - только один объект класса Connection будет создан, и только он будет использоваться.
class Connection { //этот класс как бы представляет собой соединение к серверу, это ценный ресурс, и мы хотим разделить его между потоками.
    private static Connection connection = new Connection(); // так как static, то это поле будет одним на весь класс, и, получается единственным экземпляром класса Connection. Паттерн Singleton.
    private int connectionsCount;

    private Connection() { // Приватный конструктор, чтобы предотвратить создание объектов извне.

    }

    public static Connection getConnection() { //метод, возвращающий наш единственный экземпляр класса Connection.
        return connection;
    }

    public void doWork() throws InterruptedException {
        synchronized (this) {
            connectionsCount++;
            System.out.println("connectionsCount : " + connectionsCount);
        }
        Thread.sleep(5000); // симулируем какую-то полезную работу.
        synchronized (this) { // после того как выполнили какую-то полезную работу с нашим соединением, например, отослали какой-то файл на сервер, декрементируем нашу переменную.
            connectionsCount--;
            System.out.println("Поток : " + Thread.currentThread().getName() + " доделал работу."); //потоки выполняют работу практически одновременно.
        }
    }
}
