package org.example.multithreading.alishev.producer_consumer.wait_notify.chatGPT4o;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(() -> {
            for (int i = 4; i < 10; i++) {
                resource.produce(i);
                System.out.println("Produced: " + i);
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 4; i < 10; i++) {
                int value = resource.consume();
                System.out.println("Consumed: " + value);
            }
        });

        producer.start();
        consumer.start();
    }
}
class SharedResource {
    private int data;
    private boolean available = false;

    public synchronized void produce(int value) {
        while (available) {
            System.out.println("pro1");
            try {
                wait(); // Ждем, пока ресурс не станет доступным для записи
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("pro2");
        data = value;
        available = true;
        notify(); // Уведомляем потребителя, что данные готовы
    }

    public synchronized int consume() {
        while (!available) {
            System.out.println("con1");
            try {
                wait(); // Ждем, пока данные не станут доступны
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("con2");
        available = false;
        notify(); // Уведомляем производителя, что данные были потреблены
        return data;
    }
}
