package com.company;

import java.util.HashMap;
import java.util.Optional;

public class DeliverOrder {
    private HashMap<Integer, Burger> orderedBurgers = new HashMap();

    public void orderBurger() {

        Burger burger = new Burger(Ingredients.Bread, Ingredients.Bread, Ingredients.Patty, OptionalIngredients.Cheese, OptionalIngredients.Cocktail);

    }


}
