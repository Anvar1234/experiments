package org.example.from18sem3;

import java.util.*;

public class Task2 {
    public static void main(String[] args) {
        List<String> planets = new ArrayList<>();
        planets.add("Earth");
        planets.add("Venus");
        planets.add("Earth");
        planets.add("Mars");
        planets.add("Venus");
        planets.add("Venus");

        Map<String, Integer> exclusivePlanets = new HashMap<>();

        for (int i = 0; i < planets.size(); i++) {
            int count = 0;
            String currentPlanet = planets.get(i);
            for (String s : planets) {
                if (s.equals(planets.get(i))) {
                    count++;
                }
            }
            exclusivePlanets.put(currentPlanet, count);
        }
        for (Map.Entry<String, Integer> s : exclusivePlanets.entrySet()) {
            System.out.printf("Planet %s appears %s times \n", s.getKey(), s.getValue());
        }
    }
}
