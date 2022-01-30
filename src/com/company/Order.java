package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Order {

    /**
     * This method generates a Burger with random optional ingredients
     *
     * @param menu the menu where all Burgers are saved
     */
    public static void CreateBurger(Menu menu) {
        /**
         * you can only make a new Burger if you have less than 4 orders open
         */
        if (menu.getBurgerList().size() < 4) {
            int amountOptionalIngredients = new Random().nextInt(OptionalIngredients.values().length);
            ArrayList<OptionalIngredients> optionalIngredients = new ArrayList<OptionalIngredients>();

            /**
             * iterates through the optional ingredients and picks a random one
             */
            for (int i = 0; i < amountOptionalIngredients; i++) {
                int pick = new Random().nextInt(OptionalIngredients.values().length);
                if (!optionalIngredients.contains(OptionalIngredients.values()[pick])) {
                    optionalIngredients.add(OptionalIngredients.values()[pick]);
                }
            }
            /**
             * adds the Burger to the burgerlist with the optional ingredients
             */
            menu.getBurgerList().add(new Burger(optionalIngredients));

            /**
             * print out the burger which was generated
             */
            menu.getBurgerList().forEach(burger -> IO.drawMultipleBox(menu.getBurgerList().size() + 1, 1, 1, "Standard ingredients: " + burger.getIngredientsList() + " Optional ingredients" + burger.getOptionalIngredientsList()));
            /**
             * if you have 4 orders open, this error message will be shown!
             */
        } else {
            System.err.println("You can't recieve orders, you still got some open!");
        }
    }
}