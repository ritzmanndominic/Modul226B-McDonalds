package com.company;

import java.util.ArrayList;

public class Menu {

    private ArrayList<Burger> BurgerList;

    public Menu() {
        BurgerList = new ArrayList<Burger>();
    }

    public void printMenu() {
        int index = 0;
        if (BurgerList.size() != 0) {
            for (Burger i : BurgerList) {
                IO.drawMultipleBox(BurgerList.size() + 1, 1, 1, "Index: " + index + " Standard ingredients: " + i.getIngredientsList() + " Optional ingredients" + i.getOptionalIngredientsList());
                index++;
            }

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