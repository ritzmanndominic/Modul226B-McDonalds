package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Order {

    public static void CreateBurger(Menu menu) {
        int amountOptionalIngredients = new Random().nextInt(OptionalIngredients.values().length);
        ArrayList<Ingredients> ingredients = new ArrayList<Ingredients>();
        ArrayList<OptionalIngredients> optionalIngredients = new ArrayList<OptionalIngredients>();

        for (int i = 0; i < amountOptionalIngredients; i++) {
            int pick = new Random().nextInt(OptionalIngredients.values().length);
            if (!optionalIngredients.contains(OptionalIngredients.values()[pick])) {
                optionalIngredients.add(OptionalIngredients.values()[pick]);
            }
        }
        menu.getBurgerList().add(new Burger(optionalIngredients));
    }

}