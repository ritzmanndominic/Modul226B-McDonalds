package com.company;

public class Main {

    public static void main(String[] args) {

        DeliverOrder deliverOrder = new DeliverOrder();
        Burger burger = new Burger();Burger burger1 = burger.CreateBurger();
        deliverOrder.orderBurger();
    }
}
