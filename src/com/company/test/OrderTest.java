package com.company.test;

import com.company.Menu;
import com.company.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    Menu menu = new Menu();

    @Test
    void createBurger() {
        Order.CreateBurger(menu);

        if (menu.getBurgerList().size() == 1) {
            assertTrue(true);
        }
    }
}