package com.company.test;

import com.company.DeliverOrder;
import com.company.Menu;
import com.company.Order;
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
        deliverOrder.makeBurgerMock(menu, 9, 0);
        assertTrue(true);
    }
}