package com.company;

public class Overview {

    private int choice = 0;
    Menu menu = new Menu();
    DeliverOrder deliverOrder = new DeliverOrder();

    /**
     * This method handles all methods
     */
    public void overview() {
        do {
            /**
             * Outputs all the useable methods
             */
            IO.drawMultipleBox(10, 3, 2, "1: Recieve new order", "2: Check all open orders", "3: Prepare order", "4: Deliver Burger", "9: End Simulation", "-----");
            choice = IO.readRangedInt(1, 9);

            /**
             * switch case for the methods
             * ends when the user presses the number '9'
             */
            switch (choice) {
                case 1 ->//Recieve new order
                        Order.CreateBurger(menu);
                case 2 -> //Check all open orders
                        menu.printMenu();
                case 3 ->
                        //Prepare order
                        deliverOrder.makeBurger(menu);
                case 4 -> //deliver order
                        deliverOrder.deliverOrderedBurger(menu);
                case 9 ->
                        //End Simulation
                        System.exit(0);
            }
        } while (choice != 9);
    }
}
