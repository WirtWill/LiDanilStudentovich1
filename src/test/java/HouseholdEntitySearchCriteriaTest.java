import org.example.criteria.HouseholdCriteria;
import org.example.entity.HouseholdEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class HouseholdEntitySearchCriteriaTest {

    @Test
    public void testSearchById() {
        List<HouseholdEntity> inventory = new ArrayList<>();
        HouseholdCriteria searchCriteria = new HouseholdCriteria();
        inventory.add(new HouseholdEntity(1, "Item1", "Category1", 10.0, 5));
        inventory.add(new HouseholdEntity(2, "Item2", "Category2", 20.0, 10));
        inventory.add(new HouseholdEntity(3, "Item3", "Category1", 15.0, 8));

        List<HouseholdEntity> results = new ArrayList<>();

        searchCriteria.search(inventory, "id", "2", results);

        Assertions.assertEquals(1, results.size());
        Assertions.assertEquals(2, results.get(0).getId());
    }

    @Test
    public void testSearchByName() {
        List<HouseholdEntity> inventory = new ArrayList<>();
        HouseholdCriteria searchCriteria = new HouseholdCriteria();
        inventory.add(new HouseholdEntity(1, "Item1", "Category1", 10.0, 5));
        inventory.add(new HouseholdEntity(2, "Item2", "Category2", 20.0, 10));
        inventory.add(new HouseholdEntity(3, "Item3", "Category1", 15.0, 8));

        List<HouseholdEntity> results = new ArrayList<>();

        searchCriteria.search(inventory, "name", "item", results);


        Assertions.assertEquals(3, results.size());
        Assertions.assertEquals("Item1", results.get(0).getName());
        Assertions.assertEquals("Item2", results.get(1).getName());
        Assertions.assertEquals("Item3", results.get(2).getName());
    }

}
