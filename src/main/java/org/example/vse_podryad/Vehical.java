package org.example.vse_podryad;
//interface Vehicle {
//
//    default void print() {
//        System.out.println("I am a vehicle!");
//    }
//    static void blowHorn() {
//        System.out.println("Blowing horn!!!");
//    }
//}


//interface Vehicle {
//    default void print() {
//        System.out.println("I am a vehicle!");
//    }
//}
//class Car implements Vehicle {
//    public void print() {
//        Vehicle.super.print();
//    }
//}


interface Vehicle {
    static void blowHorn() {
        System.out.println("Blowing horn!!!");
    }
}

class Car implements Vehicle {
    public void print() {
        Vehicle.blowHorn();
    }
}
