package org.example.multithreading.habr;

public class BlockedState {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new DemoBlockedRunnable(), "DemoBlockedRunnable1");
        Thread t2 = new Thread(new DemoBlockedRunnable(), "DemoBlockedRunnable2");

        t1.start();
        t2.start();

        Thread.sleep(100);

        System.out.println(t2.getName() + " " + t2.getState());
        System.exit(0);
    }
}

class DemoBlockedRunnable implements Runnable {
    @Override
    public void run() {
        commonResource();
    }
    public static synchronized void commonResource() {
        while(true) {
            System.out.println("Hello");
        }
    }
}