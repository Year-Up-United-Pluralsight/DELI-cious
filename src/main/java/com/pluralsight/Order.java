package com.pluralsight;

public class Order {

    private Sandwich sandwich;

    public static void addSandwich() {

        System.out.print("Select your Bread: ");
        System.out.print("Sandwich Size: ");
        addToppings();
        System.out.print("Would you like the sandwich toasted? ");

    }

    public static void addToppings() {


    }

    public static void addDrink() {

        System.out.print("Drink size: ");
        System.out.print("Drink flavor: ");
    }

    public static void addChips() {

        System.out.print("Drink type: ");
    }

    public static void getOrderPrice(){

    }
}
