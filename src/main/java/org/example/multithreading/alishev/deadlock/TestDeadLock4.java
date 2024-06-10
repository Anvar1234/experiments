package org.example.multithreading.alishev.deadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
Пример решения проблемы с помощью ReentrantLock, когда еще и локи забираются в разном порядке.
 */
public class TestDeadLock4 {
    public static void main(String[] args) throws InterruptedException {
        Runner4 runner = new Runner4();

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

class Runner4 {
    private final Account4 account1 = new Account4();
    private final Account4 account2 = new Account4();
    private final Lock lock1 = new ReentrantLock();
    private final Lock lock2 = new ReentrantLock();

    private void takeLocks(Lock lock1, Lock lock2) {
        boolean firstLockTaken = false;
        boolean secondLockTaken = false;

        while (true) {
            try {
                firstLockTaken = lock1.tryLock(); //Метод tryLock() пытается получить блокировку. Если она доступна, то немедленно возвращает значение true. Если блокировка недоступна, этот метод немедленно вернет значение false.
                secondLockTaken = lock2.tryLock();
            } finally {
                if (firstLockTaken & secondLockTaken) { // из цикла мы выходим только в том случае, если попадаем в это условие, когда оба лока получены.
                    return;
                }
                //и если мы не забрали сразу оба лока по каким-то причинам, то дальше освобождаем тот лок, что занят:
                if (firstLockTaken) { // если этот занят, то его.
                    lock1.unlock();
                }
                if (secondLockTaken) { // если этот занят, то его.
                    lock2.unlock();
                }
            }
            try {
                Thread.sleep(1); //после каждой неудачной попытки взятия лока будем спать, чтобы дать время другим потокам отдать эти локи.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void firstThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            takeLocks(lock1, lock2);
//            lock1.lock();
//            //первый поток застрял здесь
//            lock2.lock();
            try {
                Account4.transfer(account1, account2, random.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }

    public void secondThread() {
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            takeLocks(lock2, lock1);
//            lock2.lock();
//            //второй поток застрял здесь
//            lock1.lock();
            try {
                Account4.transfer(account2, account1, random.nextInt(100));
            } finally {
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

class Account4 {
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

    public static void transfer(Account4 acc1, Account4 acc2, int amount) {
        acc1.withdraw(amount);
        acc2.deposit(amount);
    }
}