package org.example.multithreading.alishev.producer_consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
Реализация паттерна producer-consumer как в примере с ArrayBlockingQueue, но при
помощи wait и notify.
 */
public class MyTest {
    public static void main(String[] args) throws InterruptedException {
        MyProducerConsuner producerConsuner = new MyProducerConsuner(new ArrayList<>());

        Thread thread1 = new Thread(producerConsuner::producer, "thread1");
        Thread thread2 = new Thread(producerConsuner::consumer, "thread2");

        System.out.println("threads 1 and 2 started!");
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("main thread finished");
    }
}

class MyProducerConsuner {
    private final int MAXSIZE = 5;
    private final List<Integer> integerList;
    private final Object lock = new Object(); //Объект для синхронизации. Должен быть константой.

    private volatile boolean runFlag = true; //булевый флаг для продолжения/остановки операций внутри методов и потоков.

    public MyProducerConsuner(List<Integer> inputList) {
        this.integerList = inputList;
    }

    public void producer() {
        Random random = new Random();

        while (!Thread.interrupted()) {
            synchronized (lock) {
                try {
                    while (integerList.size() == MAXSIZE) {
                        lock.wait();
                    }
                    if (runFlag) {
                        while (integerList.size() != MAXSIZE) {
                            int randomInt = random.nextInt(100);
                            integerList.add(randomInt);
                            System.out.println("Added : " + randomInt);
                        }
                        System.out.println("integerList is full : " + integerList);
                        lock.notify(); // Как правило, последним в синхронизированном блоке ставим notify.
                    } else {
                        Thread.currentThread().interrupt(); //помечаем текущий поток на прерывание.
                        System.out.println(Thread.currentThread().getName() + " has been interrupted");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void consumer() {
        while (!Thread.interrupted()) {
            synchronized (lock) {
                try {
                    while (integerList.size() == 0) {
                        if (runFlag) {
                            lock.wait();
                        }
                    }
                    if (runFlag) {
                        int consumerIndex = 0; // индекс, для выемки элементов.
                        int consumerCounter = MAXSIZE;
                        while (consumerIndex < MAXSIZE) {
                            int taked = integerList.get(consumerIndex++);
                            System.out.printf("taked : %s " + "integerList size : %s", taked, consumerCounter-- + "\n");
                        }
                        while (integerList.size() != 0) {
                            integerList.remove((consumerIndex--) - 1);
                        }
                        System.out.println("All element removed from integerList!");
                    }
                    if (exitter()) {
                        runFlag = false;
                        System.out.println(Thread.currentThread().getName() + " has been interrupted");
                        Thread.currentThread().interrupt(); //помечаем текущий поток на прерывание.
                        lock.notify();//после завершения блока отдаем монитор первому потоку.
                    } else {
                        lock.notify();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public boolean exitter() {
        System.out.print("Exit (Y) or continue (N) : ");
        Scanner scanner = new Scanner(System.in);
        String strExit = scanner.nextLine();
        return strExit.equalsIgnoreCase("y");
    }
}