package com.company;

public class Burger {

    private Ingredients BottomBread = Ingredients.Bread;
    private Ingredients TopBread = Ingredients.Bread;
    private Ingredients Patty = Ingredients.Patty;
    private OptionalIngredients Cheese = OptionalIngredients.Cheese;
    private OptionalIngredients Cucumber = OptionalIngredients.Cucumber;
    private OptionalIngredients Onion = OptionalIngredients.Onion;
    private OptionalIngredients Pickle = OptionalIngredients.Pickle;
    private OptionalIngredients Salad = OptionalIngredients.Salad;
    private OptionalIngredients Tomato = OptionalIngredients.Tomato;
    private OptionalIngredients Bacon = OptionalIngredients.Bacon;
    private OptionalIngredients Ketchup = OptionalIngredients.Ketchup;
    private OptionalIngredients Cocktail = OptionalIngredients.Cocktail;

    public Burger(Ingredients bottomBread, Ingredients topBread, Ingredients patty, OptionalIngredients... OptionalIngredients) {
        BottomBread = bottomBread;
        TopBread = topBread;
        Patty = patty;
    }

    public Burger() {
    }
}
