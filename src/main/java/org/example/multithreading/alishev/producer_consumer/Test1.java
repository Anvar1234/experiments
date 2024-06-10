package org.example.multithreading.alishev.producer_consumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Test1 {
    private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(3);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Main start");
        Thread thread1 = new Thread(() -> {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join(); // без join main завершается до окончания работы потоков.
        thread2.join();
        System.out.println("Main stop");
    }

    private static void produce() throws InterruptedException {
        Random random = new Random();
        while (true) {
            //Особенностью метода put() у ArrayBlockingQueue является то, если очередь уже заполнена (в нашем случае 3-мя элементами), то он не добавляет новые элементы, а ждет, пока consumer возьмет элемент из очереди, и только потом снова добавляет какой-то элемент.
            // Пример, который можно привести по поводу ограничения размера очереди - это сервер, на который пользователи присылают запросы. И в случае, если обработка запросов занимает больше времени, чем время, за которое приходят запросы, то система ограничивает количество запросов, которое может прийти, в нашем случае 3-мя. Остальные пользователи ждут, когда смогут прислать свой запрос. Грубо говоря, система закрывает ворота перед пользователями, когда очередь запросов заполнена, и открывает, когда хотя бы один запрос обработан и выведен из очереди.
            int r = random.nextInt(100);
            queue.put(r);
            // консольный вывод добавлен в методах для наглядности, что добавляется и что выводится из очереди.
            System.out.println("new elem : " + r);
            System.out.println("queue.size after put : " + queue.size());
        }
    }

    private static void consumer() throws InterruptedException {
        Random random = new Random();
        while (true) {
            Thread.sleep(100);
            if(random.nextInt(10) == 5) {
                //у ArrayBlockingQueue есть методы и обычной очереди, и потокобезопасные методы. Например, есть также методы poll(), offer(), remove(), add(), которые не потокобезопасны. Метод же take() отличается потокобезопасностью.
                int taked = queue.take();
                System.out.println("taked : " + taked);
                System.out.println("queue.size after take : " + queue.size());
            }
        }
    }
}
