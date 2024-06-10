package org.example.multithreading.metanit;

public class JThread extends Thread {

    JThread(String name) {
        super(name);
    }

    public void run() {

        System.out.printf("%s started... \n", Thread.currentThread().getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Thread has been interrupted");
        }
        System.out.printf("%s fiished... \n", Thread.currentThread().getName());
    }
}

class Program {

    public static void main(String[] args) {

        System.out.println("Main thread started...");
        Thread t = new JThread("JThread");
        t.start();
        try{
            t.join();
        }
        catch(InterruptedException e){
            System.out.printf("%s has been interrupted", t.getName());
        }
        System.out.println("Main thread finished...");
    }
}