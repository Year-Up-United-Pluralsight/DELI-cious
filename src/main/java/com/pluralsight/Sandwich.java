package com.pluralsight;

public class Sandwich {

    private String bread;
    private String size;
    private Toppings toppings;
    private boolean isToasted;

    public Sandwich(String bread, String size, Toppings toppings, boolean isToasted) {
        this.bread = bread;
        this.size = size;
        this.toppings = toppings;
        this.isToasted = isToasted;
    }
}
