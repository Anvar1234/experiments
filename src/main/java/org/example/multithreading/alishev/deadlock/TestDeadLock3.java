package org.example.multithreading.alishev.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Пример решения проблемы с помощью ReentrantLock.
 */
public class TestDeadLock3 {
    public static void main(String[] args) throws InterruptedException {
        Runner3 runner = new Runner3();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.firstThread();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                runner.secondThread();
            }
        });
        long startTime = System.currentTimeMillis();

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        runner.finished();

        long stopTime = System.currentTimeMillis();
        System.out.println("Понадобилось времени : " + (stopTime - startTime));
    }
}

class Runner3 {
    private final Account3 account1 = new Account3();
    private final Account3 account2 = new Account3();
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    public void firstThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            lock1.lock();
            lock2.lock();
            try {
                Account3.transfer(account1, account2, random.nextInt(100));
            }finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            lock1.lock();
            lock2.lock();
            try {
                Account3.transfer(account2, account1, random.nextInt(100));
            }finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void finished() { //метод, который будет вызываться после работы обоих потоков.
        System.out.println("Account1 balance : " + account1.getBalance());
        System.out.println("Account2 balance : " + account2.getBalance());
        System.out.println("Total balance : " + (account1.getBalance() + account2.getBalance()));
    }
}

class Account3 {
    private int balance = 10000;

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public int getBalance() {
        return balance;
    }

    public static void transfer(Account3 acc1, Account3 acc2, int amount) {
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }
}