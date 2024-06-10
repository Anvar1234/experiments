package org.example.impl;

import org.example.Parent;

import java.util.Map;

public class Child2 extends Parent {
    private String id;
    private int number;

    @Override
    public Map<String, Integer> getParentMap() {
        return (Map<String, Integer>) super.getParentMap();
    }
}



