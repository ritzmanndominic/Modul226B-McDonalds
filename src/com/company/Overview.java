package com.company;

public class Overview {

    private int choice = 0;
    Menu menu = new Menu();
    DeliverOrder deliverOrder = new DeliverOrder();

    public void overview() {

        do {
            IO.drawMultipleBox(10, 3, 3, "1: Recieve new order", "2: Check all open orders", "3: Prepare order", "9: End Simulation");
            choice = IO.readRangedInt(1, 9);

            switch (choice) {
                case 1: {
                    //Recieve new order
                    Order.CreateBurger(menu);
                    break;
                }
                case 2: {
                    //Check all open orders
                    menu.printMenu();
                    break;
                }

                case 3: {
                    //Prepare order
                    deliverOrder.orderBurger();
                    break;
                }
                case 9: {
                    //End Simulation
                    System.exit(0);
                    break;
                }
            }
        } while (choice != 9);


    }


}
