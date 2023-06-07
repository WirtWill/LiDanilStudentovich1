package org.example.service;

import org.example.criteria.HouseholdCriteria;
import org.example.entity.HouseholdEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseHoldService {

    private final HouseholdCriteria householdCriteria = new HouseholdCriteria();

    public void showHouseholds(List<HouseholdEntity> householdEntities) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Select a sorting criterion (ID, name, category, price, or quantity): ");
        String sortBy = scanner.nextLine().trim().toLowerCase();
        householdCriteria.showSortedHousehold(householdEntities, sortBy);
        System.out.println("Household list (sorted by " + sortBy + "):");
        System.out.println("--------------------------------------------------");
        System.out.printf("%-4s %-20s %-25s %-6s %-8s\n", "ID", "Name", "Category", "Price", "Quantity");
        System.out.println("--------------------------------------------------");
        for (HouseholdEntity householdEntity : householdEntities) {
            System.out.printf("%-4d %-20s %-25s %-6.2f %-8d\n",
                    householdEntity.getId(), householdEntity.getName(), householdEntity.getCategory(),
                    householdEntity.getPrice(), householdEntity.getQuantity());
        }
        System.out.println("--------------------------------------------------");
    }

    public void searchHouseholds(List<HouseholdEntity> householdEntities) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Select a search criterion (ID, name, category, price, or quantity): ");
            String parameter = scanner.nextLine().trim().toLowerCase();
            System.out.print("Enter the search value: ");
            String value = scanner.nextLine().trim().toLowerCase();
            List<HouseholdEntity> results = new ArrayList<>();
            householdCriteria.search(householdEntities, parameter, value, results);
            if (results.isEmpty()) {
                System.out.println("No products found.");
                return;
            }
            System.out.println("Search results:");
            System.out.println("-----------------------------------------");
            System.out.printf("%-4s %-20s %-25s %-6s %-8s\n", "ID", "Name", "Category", "Price", "Quantity");
            System.out.println("-----------------------------------------");
            for (HouseholdEntity householdEntity : results) {
                System.out.printf("%-4d %-20s %-25s %-6.2f %-8d\n",
                        householdEntity.getId(), householdEntity.getName(), householdEntity.getCategory(),
                        householdEntity.getPrice(), householdEntity.getQuantity());
            }
            System.out.println("-----------------------------------------");

        } catch (NumberFormatException e) {
            System.out.println("Invalid search value. Please provide a valid value.");
        }
    }

}
