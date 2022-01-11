package com.company;

public class Burger {

    private Ingredients BottomBread = Ingredients.Bread;
    private Ingredients TopBread = Ingredients.Bread;
    private Ingredients Patty = Ingredients.Patty;

    public Burger(Ingredients bottomBread, Ingredients topBread, Ingredients patty) {
        BottomBread = bottomBread;
        TopBread = topBread;
        Patty = patty;
    }
}
