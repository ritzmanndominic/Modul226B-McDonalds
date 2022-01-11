package com.company;

public class Bigmac extends Burger {

    private Ingredients Cheese = Ingredients.Cheese;
    private Ingredients Cucumber = Ingredients.Cucumber;
    private Ingredients Ketchup = Ingredients.Ketchup;
    private Ingredients Salat = Ingredients.Salat;
    private Ingredients Onion = Ingredients.Onion;
    private Ingredients Tomato = Ingredients.Tomato;
    private Ingredients Pickle = Ingredients.Pickle;

    public Bigmac(Ingredients bottomBread, Ingredients topBread, Ingredients patty, Ingredients cheese,
                  Ingredients cucumber, Ingredients ketchup, Ingredients salat, Ingredients onion,
                  Ingredients tomato, Ingredients pickle) {
        super(bottomBread, topBread, patty);
        Cheese = cheese;
        Cucumber = cucumber;
        Ketchup = ketchup;
        Salat = salat;
        Onion = onion;
        Tomato = tomato;
        Pickle = pickle;
    }

}
