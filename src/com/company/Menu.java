package com.company;

import java.util.ArrayList;

public class Menu {

    /**
     * Arraylist where all Burgers are saved
     */
    private ArrayList<Burger> BurgerList;

    public Menu() {
        BurgerList = new ArrayList<Burger>();
    }

    /**
     * prints all Burgers which are ordered
     */
    public void printMenu() {
        int index = 0;
        if (BurgerList.size() != 0) {
            for (Burger i : BurgerList) {
                IO.drawMultipleBox(BurgerList.size() + 1, 1, 1, "Index: " + index + " Standard ingredients: " + i.getIngredientsList() + " Optional ingredients" + i.getOptionalIngredientsList());
                index++;
            }

            /**
             * if there are no orders, this error message will be shown!
             */
        } else {
            System.err.println("There are no orders!");
        }
    }

    public ArrayList<Burger> getBurgerList() {
        return BurgerList;
    }

    public void setBurgerList(ArrayList<Burger> burgerList) {
        BurgerList = burgerList;
    }
}