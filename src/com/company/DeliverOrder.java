package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class DeliverOrder {
    /**
     * finishedBurgers has all Burgers which are created
     * optionalIngredients has all ingredients which are chosen
     * choice which ingredient should be added
     * chooseOrder choose the order you want to make
     */
    private HashMap<Integer, Burger> finishedBurgers = new HashMap();
    private ArrayList<OptionalIngredients> optionalIngredients = new ArrayList<OptionalIngredients>();
    private int choice = 0;
    private int chooseOrder = 0;

    public DeliverOrder(HashMap<Integer, Burger> finishedBurgers, ArrayList<OptionalIngredients> optionalIngredients, int choice, int chooseOrder) {
        this.finishedBurgers = finishedBurgers;
        this.optionalIngredients = optionalIngredients;
        this.choice = choice;
        this.chooseOrder = chooseOrder;
    }

    public DeliverOrder() {
    }

    /**
     * make the burger which was ordered
     *
     * @param menu menu where the burgers are saved
     */
    public void makeBurger(Menu menu) {
        if (menu.getBurgerList().size() != 0) {
            chooseOrder(menu);
            do {
                /**
                 * ingredients that can be added
                 */
                IO.drawMultipleBox(20, (OptionalIngredients.values().length / 2) + 1, (OptionalIngredients.values().length / 4), "0: Salad", "1: Tomato", "2: Cucumber", "3: Cheese", "4: Cocktail", "5: Ketchup", "6: Bacon", "7: Pickle", "8: Onion", "9: Done");
                choice = IO.readRangedInt(0, 9);

                if (choice != 9) {
                    /**
                     * add the ingredients to the optionalIngredients Arraylist
                     */
                    if (!optionalIngredients.contains(OptionalIngredients.values()[choice])) {
                        optionalIngredients.add(OptionalIngredients.values()[choice]);
                    }
                    optionalIngredients.forEach(ingredient -> System.out.println(ingredient.toString()));
                }
            } while (choice != 9);
            /**
             * create the burger with the optional ingredients
             */
            finishedBurgers.put(finishedBurgers.size() + 1, new Burger(optionalIngredients));

            /**
             * print out the made burger
             */
            IO.drawMultipleBox(20, 1, 1, "Ingredients " + finishedBurgers.get(1).getIngredientsList() + ", optional ingredients " + finishedBurgers.get(1).getOptionalIngredientsList());
            /**
             * this error message is displayed when you have no orders
             */
        } else {
            System.err.println("You first need to recieve a new order to make a Burger!");
        }
    }

    public void makeBurgerMock(Menu menu, int choice) {
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

    /**
     * choose which order you want to make
     *
     * @param menu menu where all burgers are saved
     */
    public void chooseOrder(Menu menu) {
        IO.drawSingleBox("Choose your order", 18);
        menu.printMenu();
        chooseOrder = IO.readRangedInt(0, 3);
        /**
         * all burgers which can be made
         */
        IO.drawMultipleBox(menu.getBurgerList().size() + 1, 1, 1, "Standard ingredients: " + menu.getBurgerList().get(chooseOrder).getIngredientsList() + " Optional ingredients" + menu.getBurgerList().get(chooseOrder).getOptionalIngredientsList());
    }

    public void chooseOrderMock(Menu menu, int choose) {
        IO.drawSingleBox("Choose your order", 18);
        menu.printMenu();
        IO.drawMultipleBox(menu.getBurgerList().size() + 1, 1, 1, "Standard ingredients: " + menu.getBurgerList().get(chooseOrder).getIngredientsList() + " Optional ingredients" + menu.getBurgerList().get(chooseOrder).getOptionalIngredientsList());
    }

    /**
     * deliver the ordered burger
     *
     * @param menu menu where all burgers are saved
     */
    public void deliverOrderedBurger(Menu menu) {
        int rightIngredients = 40;
        int falseIngredients = 0;

        if (menu.getBurgerList().size() != 0 && finishedBurgers.size() != 0) {
            /**
             * print the ordered burger and the made burger
             */
            IO.drawMultipleBox(20, 1, 1, "Ordered Burger " + menu.getBurgerList().get(0).getIngredientsList() + " " + menu.getBurgerList().get(0).getOptionalIngredientsList());
            IO.drawMultipleBox(20, 1, 1, "Burger made " + finishedBurgers.get(1).getIngredientsList() + " " + finishedBurgers.get(1).getOptionalIngredientsList());

            /**
             * check if the choosen ingredients are in the ordered burger
             * for the right ingredients you get the points added
             * for false ingredients you get minus points
             */
            for (int i = 0; i < finishedBurgers.get(1).getOptionalIngredientsList().size(); i++) {
                OptionalIngredients ingredient = finishedBurgers.get(1).getOptionalIngredientsList().get(i);

                /**
                 * special case
                 * if there are no optional ingredients and there where no optional ingredients added, the points are set to 100
                 * if there are no optional ingredients and there where added optional ingredients, the points are set to -100
                 */
                if (menu.getBurgerList().get(chooseOrder).getOptionalIngredientsList().size() == 0 && finishedBurgers.get(1).getOptionalIngredientsList().size() == 0) {
                    rightIngredients = 100;
                } else if (menu.getBurgerList().get(chooseOrder).getOptionalIngredientsList().size() == 0 && finishedBurgers.get(1).getOptionalIngredientsList().size() != 0) {
                    falseIngredients = 100;
                } else {
                    /**
                     * check if choosen ingredient is in the ordered burger
                     */
                    for (int k = 0; k < menu.getBurgerList().get(chooseOrder).getOptionalIngredientsList().size(); k++) {
                        boolean ingredientEquals = menu.getBurgerList().get(chooseOrder).getOptionalIngredientsList().contains(ingredient);

                        if (ingredientEquals == true) {
                            rightIngredients++;
                        } else {
                            falseIngredients++;
                        }
                    }

                }
            }
            /**
             * Points you got for the burger
             */
            IO.drawSingleBox("Points " + (rightIngredients - falseIngredients), 20);

            /**
             * remove the ordered burger
             */
            menu.getBurgerList().remove(chooseOrder);

            /**
             * remove the optional ingredients
             */
            if (optionalIngredients.size() != 0) {
                optionalIngredients.removeAll(optionalIngredients);
            }

        } else {
            System.err.println("You first need to create a Burger to deliver one!");
        }
    }



    public void deliverOrderedBurgerMock(Menu menu, int chooseOrder) {
        int rightIngredients = 40;
        int falseIngredients = 0;

        if (menu.getBurgerList().size() != 0) {
            /**
             * print the ordered burger and the made burger
             */
            IO.drawMultipleBox(20, 1, 1, "Ordered Burger " + menu.getBurgerList().get(0).getIngredientsList() + " " + menu.getBurgerList().get(0).getOptionalIngredientsList());
            IO.drawMultipleBox(20, 1, 1, "Burger made " + finishedBurgers.get(1).getIngredientsList() + " " + finishedBurgers.get(1).getOptionalIngredientsList());

            /**
             * check if the choosen ingredients are in the ordered burger
             * for the right ingredients you get the points added
             * for false ingredients you get minus points
             */
            for (int i = 0; i < finishedBurgers.get(1).getOptionalIngredientsList().size(); i++) {
                OptionalIngredients ingredient = finishedBurgers.get(1).getOptionalIngredientsList().get(i);

                /**
                 * special case
                 * if there are no optional ingredients and there where no optional ingredients added, the points are set to 100
                 * if there are no optional ingredients and there where added optional ingredients, the points are set to -100
                 */
                if (menu.getBurgerList().get(chooseOrder).getOptionalIngredientsList().size() == 0 && finishedBurgers.get(1).getOptionalIngredientsList().size() == 0) {
                    rightIngredients = 100;
                } else if (menu.getBurgerList().get(chooseOrder).getOptionalIngredientsList().size() == 0 && finishedBurgers.get(1).getOptionalIngredientsList().size() != 0) {
                    falseIngredients = 100;
                } else {
                    /**
                     * check if choosen ingredient is in the ordered burger
                     */
                    for (int k = 0; k < menu.getBurgerList().get(chooseOrder).getOptionalIngredientsList().size(); k++) {
                        boolean ingredientEquals = menu.getBurgerList().get(chooseOrder).getOptionalIngredientsList().contains(ingredient);

                        if (ingredientEquals == true) {
                            rightIngredients++;
                        } else {
                            falseIngredients++;
                        }
                    }

                }
            }
            /**
             * Points you got for the burger
             */
            IO.drawSingleBox("Points " + (rightIngredients - falseIngredients), 20);

            /**
             * remove the ordered burger
             */
            menu.getBurgerList().remove(chooseOrder);

            /**
             * remove the optional ingredients
             */
            if (optionalIngredients.size() != 0) {
                optionalIngredients.removeAll(optionalIngredients);
            }

        } else {
            System.err.println("You first need to create a Burger to deliver one!");
        }
    }

}