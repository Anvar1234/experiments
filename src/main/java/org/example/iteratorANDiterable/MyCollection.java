package org.example.iteratorANDiterable;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyCollection implements Iterable<MyEntity> {
    private List<MyEntity> numberList = new ArrayList<>();
    private int index;


    public MyCollection add(MyEntity element) {
        numberList.add(element);
        return this;
    }

    //1 вариант итератора в виде анонимного класса.
    //    @NotNull
//    @Override
//    public Iterator<MyEntity> iterator() {
//        return new Iterator<MyEntity>() {
//
//            @Override
//            public boolean hasNext() {
//                return index < numberList.size();
//            }
//
//            @Override
//            public MyEntity next() {
//                return numberList.get(index++);
//            }
//        };
//    }
    //2 вариант итератора в виде возвращаемого типа стороннего класса.
//    public Iterator<MyEntity> iterator() {
//            return new MyIterator<>(numberList);
//    }
    //3 вариант итератора в виде внутреннего класса.
    private class MyInnerClassIterator implements Iterator {

        @Override
        public boolean hasNext() {
            return index < numberList.size();
        }

        @Override
        public MyEntity next() {
            return numberList.get(index++);
        }

        public void resetIterator() {
            index = 0;
        }

    }

    @Override
    public Iterator<MyEntity> iterator() {
        MyInnerClassIterator myInnerClassIterator = new MyInnerClassIterator();
        myInnerClassIterator.resetIterator();
        return myInnerClassIterator;
    }
}
