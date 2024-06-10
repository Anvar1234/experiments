package org.example.multithreading.alishev.deadlock;

import java.util.Random;

public class TestDeadLock2 {
    public static void main(String[] args) throws InterruptedException {
        Runner2 runner = new Runner2();

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

class Runner2 {
    private final Account2 account1 = new Account2();
    private final Account2 account2 = new Account2();


    public void firstThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            synchronized (account1) { //данные блоки потоком будут выполняться только тогда, когда поток завладеет и монитором первого объекта, и монитором второго.
                synchronized (account2) {
                    Account2.transfer(account1, account2, random.nextInt(100));
                }
            }
        }
    }

    public void secondThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            synchronized (account1) { //Второй поток будет ожидать где-то здесь, так как у него нет ни монитора первого объекта, ни монитора второго.
                synchronized (account2) {
                    Account2.transfer(account2, account1, random.nextInt(100));
                }
            }
        }
    }

    public void finished() { //метод, который будет вызываться после работы обоих потоков.
        System.out.println("Account1 balance : " + account1.getBalance());
        System.out.println("Account2 balance : " + account2.getBalance());
        System.out.println("Total balance : " + (account1.getBalance() + account2.getBalance()));
    }
}

class Account2 {
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

    public static void transfer(Account2 acc1, Account2 acc2, int amount) {
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }
}