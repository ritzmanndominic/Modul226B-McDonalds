package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Burger {
    private ArrayList<Ingredients> ingredientsList;
    private ArrayList<OptionalIngredients> OptionalIngredientsList = new ArrayList<OptionalIngredients>() {
    };

    public Burger(ArrayList<OptionalIngredients> optionalIngredients) {
        ingredientsList = new ArrayList<Ingredients>(Arrays.asList(Ingredients.Bread, Ingredients.Bread, Ingredients.Patty));
        OptionalIngredientsList = optionalIngredients;
    }

    public Burger() {
    }

    public ArrayList<Ingredients> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(ArrayList<Ingredients> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public ArrayList<OptionalIngredients> getOptionalIngredientsList() {
        return OptionalIngredientsList;
    }

    public void setOptionalIngredientsList(ArrayList<OptionalIngredients> optionalIngredientsList) {
        OptionalIngredientsList = optionalIngredientsList;
    }
}