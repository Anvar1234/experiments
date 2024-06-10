package org.example.work_with_properties;

import java.io.*;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Properties;

public class MyPropertie {
    public static void main(String[] args) throws FileNotFoundException {
        // Путь к файлу свойств
//        Path path = Path.of("src/main/resources/config.properties");
//
//        Path absPath = path.toAbsolutePath();
//        System.out.println("absPath = " + absPath);
//
//        Path pathParent = path.getParent();
//        System.out.println("pathParent = " +pathParent);

        String propertiesFilePath = "src/main/resources/config.properties";

        // Загрузка свойств из файла
        Properties properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(propertiesFilePath);
            properties.load(fis);
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        // Вывод текущих свойств
        System.out.println("Текущие настройки:");
        System.out.println("app.name = " + properties.getProperty("app.name"));
        System.out.println("app.version = " + properties.getProperty("app.version"));
        System.out.println("app.str = " + properties.getProperty("app.str"));

        // Изменение значения свойства и сохранение в файл
        properties.setProperty("app.version", "2.0");
        properties.setProperty("app.version2", "3.0");
        try {
            FileOutputStream fos = new FileOutputStream(propertiesFilePath);
            properties.store(fos, "Updated app.version to 2.0");
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Вывод обновленных свойств
        System.out.println("\nОбновленные настройки:");
        System.out.println("app.name = " + properties.getProperty("app.name"));
        System.out.println("app.version = " + properties.getProperty("app.version"));

        Properties properties1 = new Properties();
        properties1.setProperty("key1", "value1");
        properties1.setProperty("key2", "value2");
        Iterator<?> iterator = properties1.propertyNames().asIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        try (FileOutputStream fos2 = new FileOutputStream("src/main/resources/config2.properties")) {
            properties1.store(fos2, "Some comment");
        } catch (IOException exp) {
            System.out.println(exp.getMessage());
        }
    }
}
