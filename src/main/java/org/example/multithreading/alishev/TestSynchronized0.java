package org.example.multithreading.alishev;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestSynchronized0 {

    public static void main(String[] args) throws InterruptedException {
        new Worker0().main();
    }
}

class Worker0 {
    Random random = new Random();
    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    public void addToList1() {
        try{
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list1.add(random.nextInt(100)); //от 0 до 99
    }

    public void addToList2() {
        try{
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        list2.add(random.nextInt(100)); //от 0 до 99
    }

    public void work() {
        for (int i = 0; i < 1000; i++) {
            addToList1();
            addToList2();
        }
    }

    public void main() {
        long before = System.currentTimeMillis();
        work();
        long after = System.currentTimeMillis();
        System.out.println("Programm took " + (after - before) + " ms to run");

        System.out.println("list1 : " + list1.size());
        System.out.println("list2 : " + list2.size());
    }
}