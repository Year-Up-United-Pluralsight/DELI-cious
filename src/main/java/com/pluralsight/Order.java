package com.pluralsight;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Order {

    private ArrayList<Sandwich> sandwiches;
    private ArrayList<Drink> drinks;
    private ArrayList<String> chips;

    private static HashMap<String, Integer> meatMap = new HashMap<>();
    private static HashMap<String, Integer> cheeseMap = new HashMap<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void displayOrderOptionsScreen() {

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
            System.out.print("Select your bread: ");
            String bread = scanner.nextLine();

            System.out.print("Sandwich size: ");
            String size = scanner.nextLine();

        // <editor-fold desc="TOPPING CHOICES">
        // Meat topping choice & extra added to  hashmap
            System.out.print("Would you like to add a meat topping? (Y/N) ");
            String wantsMeatTopping = scanner.nextLine();
            ArrayList<String> meats = new ArrayList<>();

            while (wantsMeatTopping.equalsIgnoreCase("Y")) {

                boolean isDuplicateMeat = false;
                String meatTopping;

                // Gets user meat topping; loops when meat inputted has already been added
                do {
                    System.out.print("Please enter a meat topping: ");
                    meatTopping = scanner.nextLine();

                    if (!meatMap.isEmpty()) {
                        // Checks if meat is already added
                        for (String key : meatMap.keySet()) {
                            if (key.equals(meatTopping)) {
                                System.out.print("This meat topping has already been added to your sandwich");
                                HomeScreen.printDelayedEllipsis();
                                isDuplicateMeat = true;
                            }
                        }
                    }


                } while (isDuplicateMeat);

                // Meat is not a duplicate, add it to arraylist
                meats.add(meatTopping);

                // Gets whether meat quantity is extra
                System.out.print("Would you like extra of your selected meat topping? (Y/N)");
                String wantsExtraMeat = scanner.nextLine();

                // Adds "extra" to beginning of topping name in arraylist
                if (wantsExtraMeat.equalsIgnoreCase("Y")){ meats.add("Extra " + meatTopping); }

                // Otherwise adds topping with its normal name in arraylist
                else { meats.add(meatTopping); }

                // Adds to hashmap (for price calculation) the meat topping type along with whether its quantity is extra
                meatMap.put(meatTopping, (wantsExtraMeat.equalsIgnoreCase("Y")) ? 1 : 0);
            }

        // Cheese topping choice & extra added to  hashmap
            System.out.print("Would you like to add a cheese topping? (Y/N) ");
            String wantsCheeseTopping = scanner.nextLine();
            ArrayList<String> cheeses = new ArrayList<>();

            while (wantsCheeseTopping.equalsIgnoreCase("Y")) {

                boolean isDuplicateCheese = false;
                String cheeseTopping;


                // Gets user cheese topping; loops when cheese inputted has already been added
                do {
                    System.out.print("Please enter a cheese topping: ");
                    cheeseTopping = scanner.nextLine();

                    if (!cheeseMap.isEmpty()) {

                        // Checks if cheese is already added
                        for (String key : cheeseMap.keySet()) {
                            if (key.equals(cheeseTopping)) {
                                System.out.print("This cheese topping has already been added to your sandwich");
                                HomeScreen.printDelayedEllipsis();
                                isDuplicateCheese = true;
                            }
                        }
                    }


                } while (isDuplicateCheese);


                // Adds new unique cheese to cheeses arraylist
                cheeses.add(cheeseTopping);

                // Gets whether cheese quantity is extra
                System.out.print("Would you like extra of your selected cheese topping? (Y/N)");
                boolean wantsExtraCheese = scanner.nextBoolean();
                scanner.nextLine();

                // Adds "extra" to beginning of topping name in arraylist
                if (wantsExtraCheese){ meats.add("Extra " + cheeseTopping); }

                // Otherwise adds topping with its normal name in arraylist
                else { cheeses.add(cheeseTopping); }

                // Adds to hashmap the meat topping type along with whether its quantity is extra
                cheeseMap.put(cheeseTopping, (wantsExtraCheese) ? 1 : 0);

            }

        // Other/regular toppings
            ArrayList<String> otherToppings = new ArrayList<>();
            System.out.print("Please list any other toppings you'd like to add (Press enter to exit): ");
            String toppingInput = scanner.nextLine();

            // Adds input to arraylist of toppings if user does not exit
            while (!toppingInput.isEmpty()){

                // Gets whether regular topping quantity is extra
                System.out.print("Would you like extra of your selected topping? (Y/N)");
                boolean wantsExtraTopping = scanner.nextBoolean();
                scanner.nextLine();

                // Adds "extra" to beginning of topping name
                if (wantsExtraTopping){ otherToppings.add("Extra " + toppingInput); }

                // Otherwise adds topping with its normal name
                else { otherToppings.add(toppingInput); }

                HomeScreen.printDelayedEllipsis();
                System.out.print("Please list any other toppings you'd like to add to your order (Press enter to exit): ");
                toppingInput = scanner.nextLine();
            }

        // Sauces
            ArrayList<String> allSauces = new ArrayList<>();
            System.out.print("Please list any sauces you'd like to add to your order (Press enter to exit): ");
            String sauceInput = scanner.nextLine();

            // Adds input to arraylist of sauces if user does not exit
            while (!sauceInput.isEmpty()){

                // Gets whether sauces quantity is extra
                System.out.print("Would you like extra of your selected sauce? (Y/N)");
                boolean wantsExtraSauce = scanner.nextBoolean();
                scanner.nextLine();

                // Adds "extra" to beginning of topping name
                if (wantsExtraSauce){ allSauces.add("Extra " + sauceInput); }

                // Otherwise adds topping with its normal name
                else { allSauces.add(sauceInput); }

                HomeScreen.printDelayedEllipsis();
                System.out.print("Please list any other sauces you'd like to add to your order (Press enter to exit): ");
                sauceInput = scanner.nextLine();
            }
        // </editor-fold>

            // Builds topping
            Toppings toppings = new Toppings(meats, cheeses, otherToppings, allSauces);

        // Toasted
            System.out.print("Would you like the sandwich toasted? ");
            String toastChoice = scanner.nextLine();
            scanner.nextLine();

            // Sets isToasted as bool
            boolean isToasted = toastChoice.equalsIgnoreCase("Y");

        // Builds sandwich
            Sandwich sandwich = new Sandwich(bread, size, toppings, isToasted);

            order.sandwiches.add(sandwich);

            printOrder(order);
        }

//        // Adds drink
//        else if (userChoice == 2) {
//
//        }
//
//        // Adds chips
//        else if (userChoice == 3) {
//
//        }
//
//        // Checkout
//        else if (userChoice == 4) {
//
//        }
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

//    public static void addSandwich() {
//
//        System.out.print("Select your Bread: ");
//        System.out.print("Sandwich Size: ");
//        addToppings();
//        System.out.print("Would you like the sandwich toasted? ");
//
//    }
//
//    public static void addToppings() {
//
//
//    }
//
//    public static void addDrink() {
//
//        System.out.print("Drink size: ");
//        System.out.print("Drink flavor: ");
//    }
//
//    public static void addChips() {
//
//        System.out.print("Drink type: ");
//    }
//
//    public static void getOrderPrice(){
//
//    }

    public static void printOrder(Order order){
        for (Sandwich sandwich : order.sandwiches){
            System.out.println(sandwich.getBread());
            System.out.println(sandwich.getSize());

            for (String meat : sandwich.getToppings().getMeats()){
                System.out.print(meat + ";");
            }

            for (String cheese : sandwich.getToppings().getCheeses()){
                System.out.print(cheese + ";");
            }

            for (String otherTopping : sandwich.getToppings().getOtherToppings()){
                System.out.print(otherTopping + ";");
            }

            for (String sauce : sandwich.getToppings().getSauces()){
                System.out.print(sauce + ";");
            }

            System.out.println(sandwich.getBread());

        }
    }
}
