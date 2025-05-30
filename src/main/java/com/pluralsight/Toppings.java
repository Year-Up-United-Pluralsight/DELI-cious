package com.pluralsight;

import java.util.ArrayList;
import java.util.HashMap;

public class Toppings {

    private HashMap<String, Integer> meatMap;
    private HashMap<String, Integer> cheeseMap;

    private ArrayList<String> meats;
    private ArrayList<String> cheeses;
    private ArrayList<String> otherToppings;
    private ArrayList<String> sauces;

    public Toppings(ArrayList<String> meats, ArrayList<String> cheeses, ArrayList<String> otherToppings, ArrayList<String> sauces) {
        this.meats = meats;
        this.cheeses = cheeses;
        this.otherToppings = otherToppings;
        this.sauces = sauces;
    }

    public ArrayList<String> getMeats() {
        return meats;
    }

    public ArrayList<String> getCheeses() {
        return cheeses;
    }

    public ArrayList<String> getOtherToppings() {
        return otherToppings;
    }

    public ArrayList<String> getSauces() {
        return sauces;
    }

// DISTINCTIONS
    // Premium: Meats & Cheese
    //      Name matters
    //      Price matters (since it's extra)
    // Regular: All other toppings
    //      Name matters
    // Extra
    //      For Regular: Name changes
    //      For Premium: Name changes & Price increases

    // Extra is considered to be every meat/cheese that is in addition to the first one, no matter the type
    // Ex. If there are 3 elements in the meat vector then the 2 are considered extra -- even if they are all the same type of meat (same for cheese)

    // Extra meat/cheese just means more of the currently selected meat/cheese
    // Extra does NOT mean that the user is ordering multiple types of meat/cheese
    // AKA extra is simply a boolean that adds/doesn't add an extra fee on the meat/cheese

    // How do I allow both multiple meats/cheeses AND extra for a given meat?

    // While loop
    // Prompt for type of meat/cheese
    // Then ask if they want extra
    // Loop while they want to add more types of meat/cheese

    // Check if the meat they inputted is a key in the hashmap
    // Store in a hashmap

    // ***HASHMAP IS USED PURELY FOR PRICE CALCULATION PURPOSES
    // FOR NORMAL WRITING TO RECEIPT AND WHATNOT, JUST CHANGE THE NAME OF THE GIVEN TOPPING

}
