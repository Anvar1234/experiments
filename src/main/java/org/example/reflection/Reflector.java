package org.example.reflection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Reflector {
    public static <T> void getClassName(T t) {
        Class<?> clazz = t.getClass();
        String className = clazz.getName();
        System.out.println(className);
    }

    public static <T> void showPublicFields(T t) {
        Class<?> clazz = t.getClass();
        Field[] fields = clazz.getFields();
        if (fields.length != 0) {
            for (Field field : fields) {
                System.out.println("Кролик имеет публичное поле: " + field);
            }
        } else {
            System.out.println("Кролик не имеет публичных полей");
        }
    }

    public static <T> void showDeclaredcFields(T t) {
        Class<?> clazz = t.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if (fields.length != 0) {
            for (Field field : fields) {
                System.out.println("Кролик имеет declared поле: " + field);
            }
        } else {
            System.out.println("Кролик не имеет declared полей");
        }
    }


}
