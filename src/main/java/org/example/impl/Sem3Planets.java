package org.example.impl;

import java.util.*;

public class Sem3Planets {
    public static void main(String[] args) {
        /**
         * Заполнить список названиями планет Солнечной
         * системы в произвольном порядке с повторениями.
         * Вывести название каждой планеты и количество его
         * повторений в списке.
         */
        List<String> planets = new ArrayList<>();
        planets.add("Sun");
        planets.add("Earth");
        planets.add("Pluto");
        planets.add("Earth");
        planets.add("Sun");
        planets.add("Sun");
        planets.add("Earth");

        Map<String, Integer> mapPlanets = new HashMap<>();
        int count = 0;

        for (int i = 0; i < planets.size(); i++) {
            for (int j = 0; j < planets.size(); j++) {
                if (planets.get(j).equals(planets.get(i))) {
                    count++;
                }
            }
            mapPlanets.put(planets.get(i), count);
            count = 0;
        }
        for (Map.Entry<String, Integer> entry : mapPlanets.entrySet()) {
            System.out.println("Планета " + entry.getKey() + " встречается " + entry.getValue() + " раз");
        }
//        Scanner sc = new Scanner(System.in);
//        String data = sc.next();
//        String a = "a";
//        a.add
    }
}
