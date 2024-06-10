package org.example.constructors;

public class TestPrivate {
    private static TestPrivate instance;

    private TestPrivate() {
        System.out.println("Object 'TestPrivate' is created");
    }

    public static TestPrivate getTestPrivate() {
        if (instance == null)
            instance = new TestPrivate();
        return instance;
    }
}

class Test1 {
    public static void main(String[] args) {
        TestPrivate test1 = TestPrivate.getTestPrivate();
        TestPrivate test2 = TestPrivate.getTestPrivate();
        System.out.println("" + (test1 != null));
        System.out.println("" + (test2 != null));
    }
}