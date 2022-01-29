package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class DeliverOrder {
    private HashMap<Integer, Burger> orderedBurgers = new HashMap();
    ArrayList<OptionalIngredients> optionalIngredients = new ArrayList<OptionalIngredients>();
    private int choice = 0;

    public DeliverOrder(HashMap<Integer, Burger> orderedBurgers, ArrayList<OptionalIngredients> optionalIngredients, int choice) {
        this.orderedBurgers = orderedBurgers;
        this.optionalIngredients = optionalIngredients;
        this.choice = choice;
    }

    public DeliverOrder() {

    }

    public void makeBurger() {
        do {
            IO.drawMultipleBox(20, (OptionalIngredients.values().length / 2) + 1, (OptionalIngredients.values().length / 4), "0: Salad", "1: Tomato", "2: Cucumber", "3: Cheese", "4: Cocktail", "5: Ketchup", "6: Bacon", "7: Pickle", "8: Onion", "9: Done");
            choice = IO.readRangedInt(0, 9);

            if (choice != 9) {
                if (!optionalIngredients.contains(OptionalIngredients.values()[choice])) {
                    optionalIngredients.add(OptionalIngredients.values()[choice]);
                }
                optionalIngredients.forEach(ingredient -> System.out.println(ingredient.toString()));
            }
        } while (choice != 9);
        orderedBurgers.put(orderedBurgers.size() + 1, new Burger(optionalIngredients));

        IO.drawMultipleBox(20, 1, 1, "Ingredients " + orderedBurgers.get(1).getIngredientsList() + ", optional ingredients " + orderedBurgers.get(1).getOptionalIngredientsList());
    }

    public void orderBurger() {
        
    }
}