package org.example.reflection;

public class Rabbit implements Noiseable {
    private String name;
    private int pawCount;
    public String color;
    public String color2;


    @Override
    public String getNoise(){
        return "Pisk";
    }
}
