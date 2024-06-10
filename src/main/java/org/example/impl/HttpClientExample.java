package org.example.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClientExample {
    public static void main(String[] args) {
        try {
            // Создаем объект URL для целевого URL-адреса
            URL url = new URL("http://example.com/api/endpoint");

            // Открываем соединение
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Устанавливаем метод запроса (например, GET)
            connection.setRequestMethod("GET");

            // Читаем ответ от сервера
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Выводим ответ сервера
            System.out.println(response.toString());

            // Закрываем соединение
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}