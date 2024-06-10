package org.example.enums;

public class Program2 {
    public static void main(String[] args) {
        Season[] seasons = Season.values();
        for (Season s : seasons) {
            System.out.print(s.name() + " : ");
            s.someMethod();
        }

    }
}

enum Season {
    WINTER {
        @Override
        public void someMethod() {
            System.out.println("Method of Season.WINTER");
        }
    },
    SPRING {
        @Override
        public void someMethod() {
            System.out.println("Method of Season.SPRING");
        }
    },
    SUMMER {
        @Override
        public void someMethod() {
            System.out.println("Method of Season.SUMMER");
        }
    },
    AUTUMN {
        @Override
        public void someMethod() {
            System.out.println("Method of Season.AUTUMN");
        }
    };
    abstract void someMethod();
}

