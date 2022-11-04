package com.oewami.flooring.view;

public class FlooringView {

    private UserIO io;

    /**
     *   * <<Flooring Program>>
     *    * 1. Display Orders
     *    * 2. Add an Order
     *    * 3. Edit an Order
     *    * 4. Remove an Order
     *    * 5. Export All Data
     *    * 6. Quit
     */

    public FlooringView() {
        io = new UserIO();
    }

    public String getMenu() {
//        System.out.println(String.format("\n|%-20s|| %7s || %5s", "Product Name", "Cost", "Qty"));
        io.print("*".repeat(40));
        io.print("* <<Flooring Program>>");
        io.print("* 1. Display Orders");
        io.print("* 2. Add an Order");
        io.print("* 3. Edit an Order");
        io.print("* 4. Remove an Order");
        io.print("* 5. Export all Data");
        io.print("* 6. Quit");
        io.print("*".repeat(40));

        return io.nextLine("Choice: ");
    }
}
