package com.company;

public class Overview {

    private int choice = 0;
    Menu menu = new Menu();
    DeliverOrder deliverOrder = new DeliverOrder();

    public void overview() {

        do {
            IO.drawMultipleBox(10, 3, 3, "1: Recieve new order", "2: Check all open orders", "3: Prepare order", "4: End Simulation");
            choice = IO.readRangedInt(1, 4);

            switch (choice) {
                case 1: {
                    if (menu.getBurgerList().size() == 0) {
                        Order.CreateBurger(menu);
                    } else {
                        System.err.println("You can't recieve orders, you still got some open!");
                    }
                    break;
                }
                case 2: {
                    menu.printMenu();
                    break;
                }

                case 3: {
                    deliverOrder.orderBurger();
                    break;
                }
                case 4: {
                    System.exit(0);
                }
            }
        } while (choice != 4);


    }


}
