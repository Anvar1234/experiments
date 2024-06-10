package org.example.multithreading;

public class Test3 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread4());
        thread1.start();

        Thread thread2 = new Thread(new MyThread5());
        thread2.start();

        System.out.println("Последняя строка в main");
    }

}
class MyThread4 implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("*** " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class MyThread5 implements Runnable{
    @Override
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("# " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}