package org.example.enums;

public enum Currency {
    PENNY(), NICKLE(5), DIME(10), QUARTER(25);
    private int value;
    Currency(){

    }
    Currency(int value) {
        this.value = value;
    }

    public static void main(String[] args) {
        for(Currency c : Currency.values()){
            System.out.println("Currency : " + c.value);
        }
    }
}