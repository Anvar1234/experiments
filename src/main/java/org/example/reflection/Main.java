package org.example.reflection;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Rabbit rabbit = new Rabbit();
        Reflector.getClassName(rabbit);
        Reflector.showPublicFields(rabbit);
        Reflector.showDeclaredcFields(rabbit);


        Class cls = Comparable.class;
        int mods = cls.getModifiers();
        if (Modifier.isPublic  (mods))	{ System.out.println("public");  }
        if (Modifier.isAbstract(mods))	{ System.out.println("abstract");}
        if (Modifier.isFinal   (mods))	{ System.out.println("final");   }
    }
}

