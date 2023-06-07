package org.example.view;


import org.example.controller.HouseholdController;

public class ConsoleDisplay {

    private final HouseholdController householdController = new HouseholdController();

    public static void main(String[] args) {
        System.out.println("Tableware and Household Goods Warehouse (Created on June 1, 2023)");
        System.out.println("Developer: John Smith (johnsmith@example.com)");

        System.out.println("\nMenu Choices:");
        System.out.println("1. Search for warehouse items");
        System.out.println("2. Display all warehouse items");
        System.out.println("3. Quit the program");
        ConsoleDisplay consoleDisplay = new ConsoleDisplay();
        consoleDisplay.start();
    }

    public void start() {
        householdController.householdManagement();
    }


}
