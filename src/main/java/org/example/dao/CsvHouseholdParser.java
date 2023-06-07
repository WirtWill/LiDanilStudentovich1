package org.example.dao;

import org.example.entity.HouseholdEntity;
import org.example.exception.InvalidParameterArguments;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvHouseholdParser {

    public static List<HouseholdEntity> loadHousehold(String path) {
        List<HouseholdEntity> inventory = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                String category = fields[2];
                double price = Double.parseDouble(fields[3]);
                int quantity = Integer.parseInt(fields[4]);
                HouseholdEntity householdEntity = new HouseholdEntity(id, name, category, price, quantity);
                inventory.add(householdEntity);
            }
        } catch (IOException e) {
            System.err.println("Error reading Household file: " + e.getMessage());
            throw new InvalidParameterArguments("Invalid file path for Household");
        }
        return inventory;
    }
}
