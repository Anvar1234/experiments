package org.example.reflection.vehicle_new;

import java.lang.reflect.Constructor;

interface Vehicle {
    void go();
}
class Automobile implements Vehicle {
    public void go() {
        System.out.println("\tавтомобиль поехал!");
    }
}
class Truck implements Vehicle {
    public Truck(int i) {
        super();
    }
    public void go() {
        System.out.println("\tгрузовик поехал!");
    }
}

public class ExampleClass {
    public static void main(String[] args) {
        Vehicle vehicle;
        String[] vehicleNames = {"org.example.reflection.vehicle_new.Automobile",
                "org.example.reflection.vehicle_new.Truck",
                "org.example.reflection.vehicle_new.Aircraft"};
        for (String vehicleName : vehicleNames) {
            try {
                System.out.println("Класс : " + vehicleName);
                Class<?> aClass = Class.forName(vehicleName);
                System.out.println("\tсоздание автомобиля ...");
                Constructor<?> vehicleConstructor = aClass.getConstructor(int.class);
                vehicle = (Vehicle) vehicleConstructor.newInstance(5);
                System.out.println("\tНовая сущность : " +
                        vehicle.getClass());
                vehicle.go();
            } catch (ClassNotFoundException | InstantiationException e) {
                System.out.println(e);
            } catch (Throwable th) {
                System.out.println("Throwable : " + th);
            }
        }
    }
}

