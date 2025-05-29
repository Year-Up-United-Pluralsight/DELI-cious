package com.pluralsight;
import java.util.Scanner;

public class HomeScreen {

    public static int userChoice;
    public static Scanner scanner = new Scanner(System.in);

    public static void displayHomeScreen() {

        System.out.println("=========== WELCOME TO DIN'S SANDWICH SHOP! ===========");

        System.out.print("""
                ~ Please select an option...
                    (1) New Order
                    (0) Exit
                
                ~ Enter your choice here ➤\s""");

        // Initializes scanner & user choice variable
        Scanner scanner = new Scanner(System.in);

        // Reads user input
        userChoice = scanner.nextInt();
        scanner.nextLine();
        System.out.println(); //Skip line

        // Continuously executes a new order (until user exits)
        while (userChoice != 0) {
            displayOrderOptionsScreen();
        }

        System.out.println("~ Have a good day!");
    }

    public static void displayOrderOptionsScreen() {

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
        userChoice = scanner.nextInt();
        scanner.nextLine();
        System.out.println(); //Skip line

        // Switch statement that calls the correct process() method that matches the user request
        switch(userChoice) {
            case 1:
                addSandwich();
                break;

            case 2:
                addDrink();
                break;

            case 3:
                addChips();
                break;

            case 4:
                Checkout.checkoutOrder();
                break;

            case 0:
                break;
        }
    }

}