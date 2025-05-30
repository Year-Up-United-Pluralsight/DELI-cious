package com.pluralsight;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Order {

    private ArrayList<Sandwich> sandwiches = new ArrayList<>();
    private ArrayList<Drink> drinks = new ArrayList<>();;
    private ArrayList<String> chips = new ArrayList<>();;

    // <editor-fold desc="GETTER METHODS">
    public ArrayList<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public ArrayList<Drink> getDrinks() {
        return drinks;
    }

    public ArrayList<String> getChips() {
        return chips;
    }
    // </editor-fold>

    private static Scanner scanner = new Scanner(System.in);

    public void displayOrderOptionsScreen() {

        Order order = new Order();

        // Prompts user at the end of every order to start a new order or to exit
        System.out.print("""
                ~ Please select an option...
                    (1) Add Sandwich
                    (2) Add Drink
                    (3) Add Chips
                    (4) Checkout
                    (0) Cancel Order
                
                ~ Enter your choice here ➤\s""");

        // Read's user choice
        int userChoice = scanner.nextInt();
        scanner.nextLine();
        System.out.println(); //Skip line

        // Adds sandwich
        if (userChoice == 1) {

        // GETS USER SANDWICH CHOICES
            System.out.print("Which bread would you like? ➤ ");
            String bread = scanner.nextLine();

            System.out.print("Which size would you like your sandwich to be? ➤ ");
            String size = scanner.nextLine();

        // <editor-fold desc="TOPPINGS">
        // Meat topping choice & extra added to  hashmap

            String meatTopping = "";
            ArrayList<String> meats = new ArrayList<>();
            HashMap<String, Integer> meatMap = new HashMap<>();

            // On valid input, checks if meat is already added onto sandwich
            do {
                System.out.print("Please enter a meat topping (press enter to skip) ➤ ");
                meatTopping = scanner.nextLine();

                boolean isDuplicateMeat = false;

                // Checks if current meat is a duplicate (if meatMap is populated)
                if (!meatMap.isEmpty()) {
                    // Checks if meat is already added
                    for (String key : meatMap.keySet()) {
                        if (key.equals(meatTopping)) {
                            System.out.print("This meat topping has already been added to your sandwich");
                            isDuplicateMeat = true;
                        }
                    }
                }

                // Adds meat to meatMap and meat arraylist (if it's not a duplicate)
                if (!isDuplicateMeat && !meatTopping.isBlank()) {

                    // Gets whether meat quantity is extra
                    System.out.print("Would you like extra of your selected meat topping? (Y/N) ");
                    String wantsExtraMeat = scanner.nextLine();

                    // Adds "extra" to beginning of topping name in arraylist
                    if (wantsExtraMeat.equalsIgnoreCase("Y")){ meats.add("Extra " + meatTopping); }

                    // Otherwise adds topping with its normal name in arraylist
                    else { meats.add(meatTopping); }

                    // Adds to hashmap (for price calculation) the meat topping type along with whether its quantity is extra
                    meatMap.put(meatTopping, (wantsExtraMeat.equalsIgnoreCase("Y")) ? 1 : 0);

                }


            } while (!meatTopping.isBlank());



        // Cheese topping choice & extra added to  hashmap

            String cheeseTopping = "";
            ArrayList<String> cheeses = new ArrayList<>();
            HashMap<String, Integer> cheeseMap = new HashMap<>();

            // On valid input, checks if meat is already added onto sandwich
            do {
                System.out.print("Please enter a cheese topping (press enter to skip) ➤ ");
                cheeseTopping = scanner.nextLine();

                boolean isDuplicateCheese = false;

                // Checks if current meat is a duplicate (if meatMap is populated)
                if (!cheeseMap.isEmpty()) {
                    // Checks if meat is already added
                    for (String key : cheeseMap.keySet()) {
                        if (key.equals(cheeseTopping)) {
                            System.out.print("This cheese topping has already been added to your sandwich");
                            isDuplicateCheese = true;
                        }
                    }
                }

                // Adds meat to meatMap and meat arraylist (if it's not a duplicate)
                if (!isDuplicateCheese && !cheeseTopping.isBlank()) {


                    // Gets whether meat quantity is extra
                    System.out.print("Would you like extra of your selected cheese topping? (Y/N) ");
                    String wantsExtraCheese = scanner.nextLine();

                    // Adds "extra" to beginning of topping name in arraylist
                    if (wantsExtraCheese.equalsIgnoreCase("Y")){ cheeses.add("Extra " + cheeseTopping); }

                    // Otherwise adds topping with its normal name in arraylist
                    else { cheeses.add(cheeseTopping); }

                    // Adds to hashmap (for price calculation) the meat topping type along with whether its quantity is extra
                    cheeseMap.put(cheeseTopping, (wantsExtraCheese.equalsIgnoreCase("Y")) ? 1 : 0);

                }


            } while (!cheeseTopping.isBlank());

        // Other/regular toppings
            ArrayList<String> otherToppings = new ArrayList<>();
            System.out.print("Please list any other toppings you'd like to add (press enter to skip) ➤ ");
            String toppingInput = scanner.nextLine();

            // Adds input to arraylist of toppings if user does not exit
            while (!toppingInput.isEmpty()){

                // Gets whether regular topping quantity is extra
                System.out.print("Would you like extra of your selected topping? (Y/N) ");
                String wantsExtraTopping = scanner.nextLine();

                // Adds "extra" to beginning of topping name
                if (wantsExtraTopping.equalsIgnoreCase("Y")){ otherToppings.add("Extra " + toppingInput); }

                // Otherwise adds topping with its normal name
                else { otherToppings.add(toppingInput); }

                System.out.print("Please list any other toppings you'd like to add to your order (press enter to skip) ➤ ");
                toppingInput = scanner.nextLine();
            }

        // Sauces
            ArrayList<String> allSauces = new ArrayList<>();
            System.out.print("Please list any sauces you'd like to add to your order (press enter to skip) ➤ ");
            String sauceInput = scanner.nextLine();

            // Adds input to arraylist of sauces if user does not exit
            while (!sauceInput.isEmpty()){

                // Gets whether sauces quantity is extra
                System.out.print("Would you like extra of your selected sauce? (Y/N) ");
                String wantsExtraSauce = scanner.nextLine();

                // Adds "extra" to beginning of topping name
                if (wantsExtraSauce.equalsIgnoreCase("Y")){ allSauces.add("Extra " + sauceInput); }

                // Otherwise adds topping with its normal name
                else { allSauces.add(sauceInput); }

                System.out.print("Please list any other sauces you'd like to add to your order (press enter to skip) ➤ ");
                sauceInput = scanner.nextLine();
            }
        // </editor-fold>

            // Builds topping
            Toppings toppings = new Toppings(meats, cheeses, otherToppings, allSauces);
            toppings.setMeatMap(meatMap);
            toppings.setCheeseMap(cheeseMap);

        // Toasted
            System.out.print("Would you like the sandwich toasted? (Y/N) ");
            String toastChoice = scanner.nextLine();

            // Sets isToasted as bool
            boolean isToasted = toastChoice.equalsIgnoreCase("Y");

        // Builds sandwich
            Sandwich sandwich = new Sandwich(bread, size, toppings, isToasted);

            displayOrderOptionsScreen();
        }

        // Adds drink
        else if (userChoice == 2) {
            System.out.println("What flavor would you like? ➤ ");
            String flavor = scanner.nextLine();

            System.out.println("What size drink would you like? ➤ ");
            String size = scanner.nextLine();

            Drink drink = new Drink(flavor, size);

            order.drinks.add(drink);

            displayOrderOptionsScreen();
        }

        // Adds chips
        else if (userChoice == 3) {
            System.out.println("What kind of chips would you like? ➤ ");
            String chipsInput = scanner.nextLine();

            order.chips.add(chipsInput);

            displayOrderOptionsScreen();
        }

        // Checkout
        else if (userChoice == 4) {
            Checkout.displayOrder(this);
            Checkout.displayPrice(this);

            System.out.println("Would you like to confirm or would you like to cancel your order? (Y/N) ➤ ");
            String confirmOrder = scanner.nextLine();

            if (confirmOrder.equalsIgnoreCase("Y")){
                Checkout.confirmOrder(this);
                HomeScreen.displayHomeScreen();
            }

        }
//
//        // Cancel order
//        else if (userChoice == 0) {
//
//        }
//
//        else {
//
//        }
    }

}
