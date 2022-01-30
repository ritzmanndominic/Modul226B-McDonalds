package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeliverOrderTest {
    Menu menu = new Menu();
    DeliverOrder deliverOrder = new DeliverOrder();

    @BeforeEach
    void setUp() {
        Order.CreateBurger(menu);
    }

    @Test
    void chooseOrder() {
        deliverOrder.chooseOrderMock(menu, 0);
        assertTrue(true);
    }

    @Test
    void makeBurger() {
        deliverOrder.makeBurgerMock(menu, 0);
        assertTrue(true);
    }

    @Test
    void deliverOrderedBurger() {
        deliverOrder.chooseOrderMock(menu, 0);
        deliverOrder.deliverOrderedBurgerMock(menu, 0);
        assertTrue(true);
    }
}