package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class DeliverOrder {
    private HashMap<Integer, Burger> finishedBurgers = new HashMap();
    ArrayList<OptionalIngredients> optionalIngredients = new ArrayList<OptionalIngredients>();
    private int choice = 0;

    public DeliverOrder(HashMap<Integer, Burger> finishedBurgers, ArrayList<OptionalIngredients> optionalIngredients, int choice) {
        this.finishedBurgers = finishedBurgers;
        this.optionalIngredients = optionalIngredients;
        this.choice = choice;
    }

    public DeliverOrder() {

    }

    public void makeBurger(Menu menu) {
        if (menu.getBurgerList().size() != 0) {
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
            finishedBurgers.put(finishedBurgers.size() + 1, new Burger(optionalIngredients));

            IO.drawMultipleBox(20, 1, 1, "Ingredients " + finishedBurgers.get(1).getIngredientsList() + ", optional ingredients " + finishedBurgers.get(1).getOptionalIngredientsList());
        } else {
            System.err.println("You first need to recieve a new order to make a Burger!");
        }
    }

    public void deliverOrderedBurger(Menu menu) {
        if (menu.getBurgerList().size() != 0) {

            IO.drawMultipleBox(20, 1, 1, "Ordered Burger " + menu.getBurgerList().get(0).getIngredientsList() + " " + menu.getBurgerList().get(0).getOptionalIngredientsList());

            IO.drawMultipleBox(20, 1, 1, "Burger made " + finishedBurgers.get(1).getIngredientsList() + " " + finishedBurgers.get(1).getOptionalIngredientsList());
        } else {
            System.err.println("You first need to create a Burger to deliver one!");
        }
    }
}