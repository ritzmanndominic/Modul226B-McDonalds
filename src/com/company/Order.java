package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Order {

    public static void CreateBurger(Menu menu) {
        if (menu.getBurgerList().size() < 4) {
            int amountOptionalIngredients = new Random().nextInt(OptionalIngredients.values().length);
            ArrayList<OptionalIngredients> optionalIngredients = new ArrayList<OptionalIngredients>();

            for (int i = 0; i < amountOptionalIngredients; i++) {
                int pick = new Random().nextInt(OptionalIngredients.values().length);
                if (!optionalIngredients.contains(OptionalIngredients.values()[pick])) {
                    optionalIngredients.add(OptionalIngredients.values()[pick]);
                }
            }
            menu.getBurgerList().add(new Burger(optionalIngredients));

            menu.getBurgerList().forEach(burger -> IO.drawMultipleBox(menu.getBurgerList().size() + 1, 1, 1, "Standard ingredients: " + burger.getIngredientsList() + " Optional ingredients" + burger.getOptionalIngredientsList()));
        } else {
            System.err.println("You can't recieve orders, you still got some open!");
        }
    }
}