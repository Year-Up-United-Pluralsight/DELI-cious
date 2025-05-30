package com.pluralsight;
import java.util.Scanner;

public class HomeScreen {

    public static int userChoice;
    public static Scanner scanner = new Scanner(System.in);

    public static void displayHomeScreen() {

        // Displays home screen options; prompts user for choice
        System.out.print("""
                ~ How can I help you...
                    (1) New Order
                    (0) Exit
                
                ~ Enter your choice here ➤\s""");

        // Initializes scanner
        Scanner scanner = new Scanner(System.in);

        // Reads user input if valid
        if (scanner.hasNextInt()){
            userChoice = scanner.nextInt();
            scanner.nextLine();
            System.out.println(); //Skip line
        }

        // Retries input if invalid
        else {
            if(wantsToRetry()){ displayHomeScreen();}
        }

        // Exits if input is 0
        if (userChoice == 0){
            System.out.println("~ Have a good day!");
        }

        // Orders & then loops home screen if input is 1
        else if (userChoice == 1) {
            // Brings user to order screen
            Order.displayOrderOptionsScreen();

            // Loops home screen
            displayHomeScreen();
        }
    }



// HELPER METHODS
    // Adds delayed ellipsis for screen transitions
    public static void printDelayedEllipsis(){
        // Prints delayed ellipsis...
        try {
            for (int i = 0; i < 3; i++) {
                System.out.print(".");     // Prints three periods (an ellipsis)
                Thread.sleep(300);   // Delays printing of each period
            }

            System.out.println("\n");          // Skips two lines
        }
        catch(InterruptedException e){
            System.out.println("Error");
        }
    }

    // Returns true if user wants to try again to input a valid selection; return false otherwise (both include accompanying console prints)
    private static boolean wantsToRetry() {

        // Checks if user wants to either 1) see options again or 2) exit
        System.out.print("\nSorry! I'm not sure I understand what you mean by that. Would you like to try again? (Y/N): ");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("Y")){

            // Echos user choice
            System.out.print("\nGreat! Let’s give it another go");
            printDelayedEllipsis();

            return true;
        }

        else if (response.equalsIgnoreCase("N")){
            // Echos user choice
            System.out.println("\n~ Thank you for stopping by, and have a wonderful rest of your day!");

            return false;
        }

        else {
            // If input is not Y or N, repeats prompt
            return wantsToRetry();
        }

    }

}