package org.example.enums;

import java.util.Arrays;

public class Program{

    public static void main(String[] args) {

        Book b1 = new Book("War and Peace", "L. Tolstoy", Type.BELLETRE);
        System.out.printf("Book '%s' has a type %s \n", b1.name, b1.getType());
        Type type = Type.PHANTASY;
        System.out.println("name : " + type.name());
        System.out.println("toString : " + type.toString());
        System.out.println("name : " + type.name());

        String name1 = "WINTER";

        Season season = Season.valueOf(name1);
        System.out.println("season : " + season);

        String seasonName = season.name();
        System.out.println("season.name : " + seasonName);


    }
}
class Book{

    private Type bookType;
    String name;
    String author;

    Book(String name, String author, Type type){

        this.bookType = type;
        this.name = name;
        this.author = author;
    }
    String getType(){
        switch(bookType){
            case BELLETRE: return "Belletre";
            case SCIENCE: return "Science";
            case SCIENCE_FICTION: return "Science fiction";
            case PHANTASY: return "Phantasy";
            default: return "Undefined";
        }
    }
}

enum Type{

    SCIENCE,
    BELLETRE,
    PHANTASY,
    SCIENCE_FICTION
}



//    String upperLowerCaseName = bookType.name().charAt(0) + bookType.name().substring(1).toLowerCase();
//        return upperLowerCaseName;