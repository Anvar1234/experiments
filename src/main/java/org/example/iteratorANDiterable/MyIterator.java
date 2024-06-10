package org.example.iteratorANDiterable;

import java.util.Iterator;
import java.util.List;

public class MyIterator<T> implements Iterator<T> {
    private List<T> listObjects;
    int index;

    public MyIterator(List<T> inputList) {
        this.listObjects = inputList;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < listObjects.size();
    }

    @Override
    public T next() {
        return listObjects.get(index++);
    }
}
