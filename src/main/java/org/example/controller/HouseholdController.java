package org.example.controller;

import org.example.entity.HouseholdEntity;
import org.example.service.HouseHoldService;

import java.util.List;
import java.util.Scanner;

import static org.example.dao.CsvHouseholdParser.loadHousehold;

public class HouseholdController {

    private final HouseHoldService houseHoldService = new HouseHoldService();

    public void householdManagement() {
        String WAREHOUSE_CSV_PATH = "src/main/resources/Household.csv";
        List<HouseholdEntity> householdEntity = loadHousehold(WAREHOUSE_CSV_PATH);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter your choice (1-3): ");
            String action = scanner.nextLine().toUpperCase();

            if (action.equals("1")) {
                houseHoldService.searchHouseholds(householdEntity);
            } else if (action.equals("2")) {
                houseHoldService.showHouseholds(householdEntity);
            } else if (action.equals("3")) {
                System.out.println("Exiting the warehouse system...");
                scanner.close();
                return;
            } else {
                System.out.println("Invalid action. Please enter a valid action (1-3).");
            }
        }

    }
}
