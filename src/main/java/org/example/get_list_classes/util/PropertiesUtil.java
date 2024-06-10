package org.example.get_list_classes.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
    private static final Properties APP_PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    public static String get(String key){
        return APP_PROPERTIES.getProperty(key);
    }

    //пока что не загоняем в параметры метода путь к файлу с проперти, возможно проперти файл будет один.
//Но если что, лоадер надо будет вынести в отдельный класс. А пока жестко приколачиваем.
    private static void loadProperties() {
        try (FileReader fr = new FileReader("src/main/resources/app.properties")) {//генерирует FileNotFoundEx, но так как FNFE является наследником IOEx, то мы IO и обработаем
            APP_PROPERTIES.load(fr);
        } catch (IOException ex) {
            System.out.println(ex.getMessage()); //TODO: стоит ли здесь обрабатывать, или лучше пробросить в рантайм?
        }
    }

}
