package org.example.multithreading.alishev.callable_and_future;

import java.util.Random;
import java.util.concurrent.*;


public class TestCallableAndFuture3 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future<Integer> future = executorService.submit(() -> { //нарезаем задачи в виде выполнения метода call(), а результат присваиваем переменной типа Future<Integer>.
            System.out.println("Strated");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished");
            Random random = new Random();
            int randomValue = random.nextInt(10);
            if(randomValue < 5){
                throw new Exception("Something happened"); //также теперь в потоке можем выбрасывать исключения. И это исключение дойдет до вызова метода get().
            }
            return randomValue;
        });
        executorService.shutdown();
        try {
            //Future чем-то похож на Optional, и получаем так же через get().
            int result = future.get(); //Получаем возвращаемое значение метода call(). Метод get() дожидается окончания выполнения потока. То есть поток main останавливается здесь и ждет, пока другой поток закончит работу.
            System.out.println("result : " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) { // И уже здесь мы поймаем выброшенное нами ранее исключение (если randomValue < 5, то Exception) в виде ExecutionException (Исключение Выполнения).
            Throwable exception = e.getCause(); //метод, позволяющий получить причину исключения. Причиной является бросаемый объект (тот наш Exception).
            System.out.println(exception.getMessage()); //выводим сообщение того самого исключения.
        }
    }
}
