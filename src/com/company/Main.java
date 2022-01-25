package com.company;

public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Overview overview = new Overview();
        overview.overview();
        Order.CreateBurger(menu);
        menu.printMenu();
    }
}