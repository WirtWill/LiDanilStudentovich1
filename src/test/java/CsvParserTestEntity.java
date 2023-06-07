import org.example.entity.HouseholdEntity;
import org.example.exception.InvalidParameterArguments;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.example.dao.CsvHouseholdParser.loadHousehold;

public class CsvParserTestEntity {
    @Test
    void testLoadWareHousehold() {
        // Test data
        String testFilePath = "src/main/resources/Household.csv";
        List<HouseholdEntity> expectedInventory = List.of(
                new HouseholdEntity(1, "Whisk", "Kitchen Utensils", 10.00, 25),
                new HouseholdEntity(2, "Measuring Cups", "Kitchen Utensils", 12.00, 30),
                new HouseholdEntity(3, "Cutting Board", "Kitchen Utensils", 15.00, 20),
                new HouseholdEntity(4, "Mixing Bowls", "Kitchen Utensils", 20.00, 15),
                new HouseholdEntity(5, "Dinner Plates", "Dinnerware", 10.00, 40),
                new HouseholdEntity(6, "Coffee Cups", "Dinnerware", 8.00, 35),
                new HouseholdEntity(7, "Serving Spoon", "Serve ware", 8.50, 50),
                new HouseholdEntity(8, "Gravy Boat", "Serve ware", 12.00, 15),
                new HouseholdEntity(9, "Wine Glasses", "Glassware", 20.00, 25),
                new HouseholdEntity(10, "Highball Glasses", "Glassware", 15.00, 30)
        );

        // Call the method
        List<HouseholdEntity> actualInventory = null;
        try {
            actualInventory = loadHousehold(testFilePath);
        } catch (InvalidParameterArguments e) {
            Assertions.fail("Unexpected exception: " + e.getMessage());
        }

        // Assert the results
        Assertions.assertEquals(expectedInventory.size(), actualInventory.size());
        for (int i = 0; i < expectedInventory.size(); i++) {
            HouseholdEntity expectedItem = expectedInventory.get(i);
            HouseholdEntity actualItem = actualInventory.get(i);
            Assertions.assertEquals(expectedItem.getId(), actualItem.getId());
            Assertions.assertEquals(expectedItem.getName(), actualItem.getName());
            Assertions.assertEquals(expectedItem.getCategory(), actualItem.getCategory());
            Assertions.assertEquals(expectedItem.getPrice(), actualItem.getPrice(), 0.001);
            Assertions.assertEquals(expectedItem.getQuantity(), actualItem.getQuantity());
        }
    }
}
