package org.example.criteria;

import org.example.entity.HouseholdEntity;
import org.example.exception.InvalidParameterArguments;

import java.util.Comparator;
import java.util.List;

public class HouseholdCriteria {

    public void search(List<HouseholdEntity> inventory, String searchParameter, String searchValue, List<HouseholdEntity> results) {
        for (HouseholdEntity householdEntity : inventory) {
            if (searchParameter.equals("id")) {
                if (householdEntity.getId() == Integer.parseInt(searchValue)) {
                    results.add(householdEntity);
                }
            } else if (searchParameter.equals("name")) {
                if (householdEntity.getName().toLowerCase().contains(searchValue.toLowerCase())) {
                    results.add(householdEntity);
                }
            } else if (searchParameter.equals("category")) {
                if (householdEntity.getCategory().toLowerCase().contains(searchValue.toLowerCase())) {
                    results.add(householdEntity);
                }
            } else if (searchParameter.equals("price")) {
                if (householdEntity.getPrice() == Double.parseDouble(searchValue)) {
                    results.add(householdEntity);
                }
            } else if (searchParameter.equals("quantity")) {
                if (householdEntity.getQuantity() == Integer.parseInt(searchValue)) {
                    results.add(householdEntity);
                }
            } else {
                throw new InvalidParameterArguments("Invalid search parameter.");
            }
        }
    }

    public void showSortedHousehold(List<HouseholdEntity> householdEntity, String orderBy) {
        Comparator<HouseholdEntity> comparator;

        if (orderBy.equals("id")) {
            comparator = Comparator.comparingInt(HouseholdEntity::getId);
        } else if (orderBy.equals("name")) {
            comparator = Comparator.comparing(HouseholdEntity::getName);
        } else if (orderBy.equals("category")) {
            comparator = Comparator.comparing(HouseholdEntity::getCategory);
        } else if (orderBy.equals("price")) {
            comparator = Comparator.comparingDouble(HouseholdEntity::getPrice);
        } else if (orderBy.equals("quantity")) {
            comparator = Comparator.comparingInt(HouseholdEntity::getQuantity);
        } else {
            throw new InvalidParameterArguments("Invalid parameter");
        }

        householdEntity.sort(comparator);
    }

}

