package org.example.iteratorANDiterable;

public class MyEntity {
    private final String nameOfNumber;
    private final int number;

    public MyEntity(int number, String nameOfNumber) {
        this.number = number;
        this.nameOfNumber = nameOfNumber;
    }

    @Override
    public int hashCode() {
        int result = 17; // Начальное значение
        result = 31 * result + nameOfNumber.hashCode(); // поле 1
        result = 31 * result + number;
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;

        MyEntity o = (MyEntity) obj;
        return number == o.number
                && (nameOfNumber != null && nameOfNumber.equals(o.nameOfNumber));
    }

    @Override
    public String toString() {
        return "[" + "nameOfNumber='" + nameOfNumber + '\'' + ", number=" + number + ']';
    }
}
