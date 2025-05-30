package com.pluralsight;

import java.util.Map;

public class Checkout {

    public static void displayOrder(Order order){
        for (Sandwich sandwich : order.getSandwiches()){
            System.out.print(sandwich.getBread() + "; ");
            System.out.print(sandwich.getSize() + "; ");

            for (String meat : sandwich.getToppings().getMeats()){
                System.out.print(meat + "; ");
            }

            for (String cheese : sandwich.getToppings().getCheeses()){
                System.out.print(cheese + "; ");
            }

            for (String otherTopping : sandwich.getToppings().getOtherToppings()){
                System.out.print(otherTopping + "; ");
            }

            for (String sauce : sandwich.getToppings().getSauces()){
                System.out.print(sauce + "; ");
            }

            System.out.println((sandwich.isToasted()) ? "Toasted" : "Not Toasted");

        }

        for (Drink drink : order.getDrinks()){
            System.out.println(drink.getFlavor() + "; ");
            System.out.println(drink.getSize() + "; ");
        }

        for (String singularChips : order.getChips()){
            System.out.println(singularChips);
        }
    }

    // Displays the order details and the price
    public static double displayPrice(Order order){

        double total = 00.00;

        for (Sandwich sandwich : order.getSandwiches()){

        // ADDS PRICE BASED ON SIZE PRICE
            if (sandwich.getSize() == "4\""){
                total += 5.50;

                // For every meat, adds price based on whether it's an extra or not
                for (Map.Entry<String, Integer> entry : sandwich.getToppings().getMeatMap().entrySet()){

                    if (entry.getValue() == 1){
                        total += 0.50;
                    }

                    else {
                        total += 1.00;
                    }
                }

                // For every cheese, adds price based on whether it's an extra or not
                for (Map.Entry<String, Integer> entry : sandwich.getToppings().getCheeseMap().entrySet()){
                    if (entry.getValue() == 1){
                        total += 0.30;
                    }

                    else {
                        total += 0.75;
                    }
                }
            }

            else if (sandwich.getSize() == "8\""){
                total += 7.00;

                // For every meat, adds price based on whether it's an extra or not
                for (Map.Entry<String, Integer> entry : sandwich.getToppings().getMeatMap().entrySet()){

                    if (entry.getValue() == 1){
                        total += 1.00;
                    }

                    else {
                        total += 2.00;
                    }
                }

                // For every cheese, adds price based on whether it's an extra or not
                for (Map.Entry<String, Integer> entry : sandwich.getToppings().getCheeseMap().entrySet()){
                    if (entry.getValue() == 1){
                        total += 0.60;
                    }

                    else {
                        total += 1.50;
                    }
                }
            }

            else if (sandwich.getSize() == "12\""){
                total += 8.50;

                // For every meat, adds price based on whether it's an extra or not
                for (Map.Entry<String, Integer> entry : sandwich.getToppings().getMeatMap().entrySet()){

                    if (entry.getValue() == 1){
                        total += 1.50;
                    }

                    else {
                        total += 3.00;
                    }
                }

                // For every cheese, adds price based on whether it's an extra or not
                for (Map.Entry<String, Integer> entry : sandwich.getToppings().getCheeseMap().entrySet()){
                    if (entry.getValue() == 1){
                        total += 0.90;
                    }

                    else {
                        total += 2.25;
                    }
                }
            }

        }

        for (Drink drink : order.getDrinks()){

            if (drink.getSize().equalsIgnoreCase("Small")){
                total += 2.00;
            }

            else if (drink.getSize().equalsIgnoreCase("Medium")) {
                total += 2.50;
            }

            else if ((drink.getSize().equalsIgnoreCase("Large"))){
                total += 3.00;
            }
        }

        for (String singularChips : order.getChips()){
            total += 1.50;
        }

        return total;
    }


}
