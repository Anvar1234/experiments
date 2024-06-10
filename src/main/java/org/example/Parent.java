package org.example;

import java.util.Map;

public abstract class Parent {
    private Map<?, ?> parentMap;

    public Map<?, ?> getParentMap(){
        return this.parentMap;
    }
}
