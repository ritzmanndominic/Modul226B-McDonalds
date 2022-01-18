package com.company;

import java.util.ArrayList;

public class Menu {
    
    private ArrayList<Burger> BurgerList;
    public Menu() {
        BurgerList = new ArrayList<Burger>();
    }

    public void printMenu(){
        BurgerList.forEach((i) ->  System.out.println("Standard ingredients: " + i.getIngredientsList() + "\nOptional ingredients" + i.getOptionalIngredientsList()));
    }

    public ArrayList<Burger> getBurgerList() {
        return BurgerList;
    }

    public void setBurgerList(ArrayList<Burger> burgerList) {
        BurgerList = burgerList;
    }
}
