package org.example.enums;

import java.util.Arrays;

enum Type2 {
    INT(true) {
        @Override
        public Object parse(String string) {
            return Integer.valueOf(string);
        }

    },
    INTEGER(false) {
        @Override
        public Object parse(String string) {
            return Integer.valueOf(string);
        }
    },
    STRING(false) {
        @Override
        public Object parse(String string) {
            return string;
        }

        @Override
        public void someMethod() {
            System.out.println("someMethod in Type2.STRING");;
        }
    };

    final boolean primitive;
    int thisX;

    Type2(boolean primitive) {
        this.primitive = primitive;
    }

    Type2(boolean primitive, int x) {
        this.primitive = primitive;
        this.thisX = x;
    }

    public boolean isPrimitive() {
        return primitive;
    }

    public void someMethod() {
        System.out.println("someMethod in Type2 or instance");
    }

    public abstract Object parse(String string);

    public static void main(String[] args) {

        System.out.println(Type2.class);
        System.out.println(Type2.INT.getClass() + " " + Type2.INT.getClass().getSuperclass());
        System.out.println(Type2.INTEGER.getClass() + " " + Type2.INTEGER.getClass().getSuperclass());
        System.out.println(Type2.STRING.getClass() + " " + Type2.STRING.getClass().getSuperclass());

        Type2[] types = Type2.values();

        for (Type2 t : types) {
            System.out.printf("%s is primitive : %s \n", t, t.isPrimitive());
        }

        for (Type2 t : types) {
            System.out.println("parse : " + t.parse("2"));
        }

        for (Type2 t : types) {
            t.someMethod();
        }

    }

}