package org.example.impl;

import org.example.Parent;

import java.util.Map;

public class Child1 extends Parent {
    private String id;
    private int number;

    private Map<String, Integer> childMap;

    @Override
    public Map<String, Integer> getParentMap() {
        return this.childMap;
    }
}



