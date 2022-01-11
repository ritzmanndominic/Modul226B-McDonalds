package com.company;

public class Cheesburger extends  Burger{

    private Ingredients Cheese = Ingredients.Cheese;
    private Ingredients Cucumber = Ingredients.Cucumber;
    private Ingredients Ketchup = Ingredients.Ketchup;

    public Cheesburger(Ingredients bottomBread, Ingredients topBread, Ingredients patty,
                       Ingredients cheese, Ingredients cucumber, Ingredients ketchup) {
        super(bottomBread, topBread, patty);
        Cheese = cheese;
        Cucumber = cucumber;
        Ketchup = ketchup;
    }
}
