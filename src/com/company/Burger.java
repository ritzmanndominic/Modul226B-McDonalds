package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Burger {

    private Ingredients BottomBread = Ingredients.Bread;
    private Ingredients TopBread = Ingredients.Bread;
    private Ingredients Patty = Ingredients.Patty;
    private ArrayList<OptionalIngredients> OptionalIngredientsList = new ArrayList<OptionalIngredients>() {
    };

    public Burger(ArrayList<OptionalIngredients> optionalIngredients) {
        OptionalIngredientsList = optionalIngredients;
    }

    public Burger CreateBurger() {
        int amountIngredients = new Random().nextInt(OptionalIngredients.values().length);
        ArrayList<OptionalIngredients> optionalIngredients = new ArrayList<OptionalIngredients>();

        for (int i = 0; i < amountIngredients; i++) {
            int pick = new Random().nextInt(OptionalIngredients.values().length);
            if (!optionalIngredients.contains(OptionalIngredients.values()[pick])) {
                optionalIngredients.add(OptionalIngredients.values()[pick]);
            }
        }
        return new Burger(optionalIngredients);
    }

    public Burger() {
    }
}
