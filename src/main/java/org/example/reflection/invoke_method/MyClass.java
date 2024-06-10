package org.example.reflection.invoke_method;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyClass {
    private void myMethod() {
        System.out.println("Hello from myMethod!");
    }
    private void myMethod2() {
        System.out.println("Hello from myMethod2!");
    }
}

class Main {
    public static void main(String[] args) throws Exception {
        MyClass myClass = new MyClass();
        //допустим где-то в коде мы не создаем, а встретили объект неизвестного нам класса:
        Class<?> classOfObject = myClass.getClass();
        String name = classOfObject.getSimpleName();
        System.out.println("SimpleName : " + name);

        //StringBuilder для сохранения имен методов.
        StringBuilder namesOfMethods = new StringBuilder();
        //получаем ВСЕ методы (и публичные, и приватные)
        Method[] methods = classOfObject.getDeclaredMethods();
        for (Method m : methods) {
            //помним, что каждое значение типа Method это запись вида: private void org.example.reflection.invoke_method.MyClass.myMethod2()
            System.out.println("m.toString() : " + m.toString());
            //заполняем стрингбилдер короткими именами методов.
            namesOfMethods.append(m.getName());
            namesOfMethods.append("\n");
        }
        System.out.println("StringBuilder : \n" + namesOfMethods);
        //из StringBuilder получаем массив строк.
        String[] strMethods = namesOfMethods.toString().split("\n");
        //так как у нас 2 имени в массиве (так как 2 метода в классе), то берем индексом того, который нужен.
        //понятно, что нужно как-то иначе это использовать, а не вручную менять индекс, плюс метод getMethods() не
        // гарантирует определенный порядок элементов:
        String nameOfMethod = strMethods[0].trim();
        System.out.println("truNameMeth : " + nameOfMethod);
        //получаем метод класса MyClass:
        Method methodToCall = classOfObject.getDeclaredMethod(nameOfMethod);
        //открываем доступ для изменения метода:
        methodToCall.setAccessible(true);
        //вызываем приватный метод объекта myClass.
        methodToCall.invoke(myClass);
    }
}



//        MyClass myClass = new MyClass();
//        //допустим где-то в коде мы не создаем, а встретили объект неизвестного нам класса:
//        Class<?> classOfObject = myClass.getClass();
//        String name = classOfObject.getSimpleName();
//        System.out.println("SimpleName : " + name);
//
//        //StringBuilder для сохранения имен методов.
//        StringBuilder namesOfMethods = new StringBuilder();
//        //получаем ВСЕ методы (и публичные, и приватные)
//        Method[] methods = classOfObject.getDeclaredMethods();
//        for (Method m : methods) {
//            //помним, что каждое значение типа Method это запись вида: private void org.example.reflection.invoke_method.MyClass.myMethod2()
//            System.out.println(m.toString());
//            //и при сплитовании по "." будет получаться массив вида [private void org, example, reflection, invoke_method, MyClass, myMethod()]
//            String[] methodsArray = m.toString().split("\\.");
//            //берем последний элемент массива, так как именно он и есть название метода:
//            namesOfMethods.append(methodsArray[methodsArray.length - 1]);
//            namesOfMethods.append("\n");
//        }
//        System.out.println("StringBuilder : \n" + namesOfMethods);
//        //из StringBuilder получаем массив строк.
//        String[] strMethods = namesOfMethods.toString().split("\n");
//        //так как у нас 2 имени в массиве (так как 2 метода в классе), то берем индексом того, который нужен.
//        //понятно, что нужно как-то иначе это использовать, а не вручную менять индекс:
//        String nameOfMethod = strMethods[1].trim();
//        //убираем у имени скобки:
//        String truNameOfMethod = nameOfMethod.substring(0, nameOfMethod.length()-2);
//        System.out.println("truNameMeth : " + truNameOfMethod);
//        //получаем метод класса MyClass:
//        Method methodToCall = classOfObject.getDeclaredMethod(truNameOfMethod);
//        //открываем доступ для изменения метода:
//        methodToCall.setAccessible(true);
//        //вызываем приватный метод объекта myClass.
//        methodToCall.invoke(myClass);



        //        // Получаем класс MyClass
//        Class<?> myClass = Class.forName("org.example.reflection.invoke_method.MyClass");
//
//        // Получаем конструктор класса MyClass без аргументов
//        Constructor<?> constructor = myClass.getConstructor();
//
//        // Создаем экземпляр объекта MyClass
//        Object obj = constructor.newInstance();
//
//        // Получаем метод myMethod класса MyClass
//        Method method = myClass.getMethod("myMethod");
//
//        // Вызываем метод myMethod у объекта
//        method.invoke(obj);

