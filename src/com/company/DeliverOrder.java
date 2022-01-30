package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class DeliverOrder {
    private HashMap<Integer, Burger> finishedBurgers = new HashMap();
    ArrayList<OptionalIngredients> optionalIngredients = new ArrayList<OptionalIngredients>();
    private int choice = 0;
    private int choiceOrder = 0;

    public DeliverOrder(HashMap<Integer, Burger> finishedBurgers, ArrayList<OptionalIngredients> optionalIngredients, int choice, int choiceOrder) {
        this.finishedBurgers = finishedBurgers;
        this.optionalIngredients = optionalIngredients;
        this.choice = choice;
        this.choiceOrder = choiceOrder;
    }

    public DeliverOrder() {
    }

    public void makeBurger(Menu menu) {
        if (menu.getBurgerList().size() != 0) {
            chooseOrder(menu);


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

    public void chooseOrder(Menu menu) {
        IO.drawSingleBox("Choose your order", 18);
        menu.printMenu();
        choiceOrder = IO.readRangedInt(0, 3);

        IO.drawMultipleBox(menu.getBurgerList().size() + 1, 1, 1, "Standard ingredients: " + menu.getBurgerList().get(choiceOrder).getIngredientsList() + " Optional ingredients" + menu.getBurgerList().get(choiceOrder).getOptionalIngredientsList());
    }

    public void deliverOrderedBurger(Menu menu) {
        int rightIngredients = 40;
        int falseIngredients = 0;

        if (menu.getBurgerList().size() != 0) {

            IO.drawMultipleBox(20, 1, 1, "Ordered Burger " + menu.getBurgerList().get(0).getIngredientsList() + " " + menu.getBurgerList().get(0).getOptionalIngredientsList());
            IO.drawMultipleBox(20, 1, 1, "Burger made " + finishedBurgers.get(1).getIngredientsList() + " " + finishedBurgers.get(1).getOptionalIngredientsList());

            for (int i = 0; i < menu.getBurgerList().size(); i++) {
                System.out.println(menu.getBurgerList().get(choiceOrder).getOptionalIngredientsList());
            }

            for (int i = 0; i < finishedBurgers.size(); i++) {
                System.out.println(finishedBurgers.get(1).getOptionalIngredientsList());
            }

            for (int i = 0; i < finishedBurgers.get(1).getOptionalIngredientsList().size(); i++) {
                OptionalIngredients ingredient = finishedBurgers.get(1).getOptionalIngredientsList().get(i);

                if (menu.getBurgerList().get(choiceOrder).getOptionalIngredientsList().size() == 0 && finishedBurgers.get(1).getOptionalIngredientsList().size() == 0) {
                    rightIngredients = 100;
                } else if (menu.getBurgerList().get(choiceOrder).getOptionalIngredientsList().size() == 0 && finishedBurgers.get(1).getOptionalIngredientsList().size() != 0) {
                    falseIngredients = 100;
                } else {
                    for (int k = 0; k < menu.getBurgerList().get(choiceOrder).getOptionalIngredientsList().size(); k++) {
                        boolean ingredientEquals = menu.getBurgerList().get(choiceOrder).getOptionalIngredientsList().get(k).equals(ingredient);

                        if (ingredientEquals == true) {
                            rightIngredients++;
                        } else {
                            falseIngredients++;
                        }
                    }

                }
            }
            System.out.println("Points " + (rightIngredients - falseIngredients));

            menu.getBurgerList().remove(choiceOrder);

            if (optionalIngredients.size() != 0) {
                optionalIngredients.removeAll(optionalIngredients);
            }

        } else {
            System.err.println("You first need to create a Burger to deliver one!");
        }
    }

}