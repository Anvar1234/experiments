package org.example.multithreading.alishev.deadlock;

import java.util.Random;

/*
Симулируем перевод денег со счета одного аккаунта на счет другого аккаунта.
 */
public class TestDeadLock {
    public static void main(String[] args) throws InterruptedException {
        Runner runner = new Runner();

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

class Runner {
private Account account1 = new Account();
private Account account2 = new Account();


    public void firstThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            Account.transfer(account1, account2, random.nextInt(100));
        }
    }

    public void secondThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            Account.transfer(account2, account1, random.nextInt(100));
        }
    }

    public void finished() { //метод, который будет вызываться после работы обоих потоков.
        System.out.println("Account1 balance : " + account1.getBalance());
        System.out.println("Account2 balance : " + account2.getBalance());
        System.out.println("Total balance : " + (account1.getBalance() + account2.getBalance()));
    }
}

class Account {
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

    public static void transfer(Account acc1, Account acc2, int amount) {
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }
}