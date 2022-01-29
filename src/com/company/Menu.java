package com.company;

import java.util.ArrayList;

public class Menu {

    private ArrayList<Burger> BurgerList;

    public Menu() {
        BurgerList = new ArrayList<Burger>();
    }

    public void printMenu() {
        if (BurgerList.size() != 0) {
            BurgerList.forEach((i) -> IO.drawMultipleBox(BurgerList.size() + 1, (BurgerList.size() / 2) + 1, (BurgerList.size() / 2) + 1,
                    "Standard ingredients: " + i.getIngredientsList()  + " Optional ingredients" + i.getOptionalIngredientsList()));
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