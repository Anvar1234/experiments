package org.example.multithreading.alishev.producer_consumer.wait_notify;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        WaitAndNotify waitNotify = new WaitAndNotify();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waitNotify.produce();
                } catch (InterruptedException e) {
                   e.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    waitNotify.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }
}

class WaitAndNotify {
    public void produce() throws InterruptedException {
        synchronized (this) { //синхронизация на объекте this
            System.out.println("Producer thread started");
            //wait() вызывается на том объекте, на котором синхронизирован блок/метод. Здесь можно переписать как this.wait().
            wait(); // 1 - отпускаем монитор объекта this (теперь другой поток может его захватить), 2 - ждем, пока другой поток вызовет notify().
            System.out.println("Producer thread resumed");

        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(2000);
        Scanner scanner = new Scanner(System.in);

        synchronized (this){ //синхронизация на объекте this
            System.out.println("Waiting for return key pressed");
            scanner.nextLine();
            // И notify() вызывается на том объекте, на котором синхронизирован блок/метод. Здесь можно переписать как this.notify().
            notify(); // он НЕ отпускает монитор, пока не закончит свой код! Код ниже сработает до того, как монитор перейдет обратно к thread1.
            System.out.println("Ха-ха, я еще не отпустил монитор!");
        }
    }
}