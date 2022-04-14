package hw4.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class StandardItemTest {

    @Test
    public void constructor_entityCreated_allFieldsAreAssigned() {
        String name = "Test";
        int id = 1;
        float price = 100.5F;
        String testCategory = "test category";
        int loyaltyPoints = 10;

        StandardItem item = new StandardItem(id, name, price, testCategory, loyaltyPoints);

        Assertions.assertEquals(id, item.getID());
        Assertions.assertEquals(name, item.getName());
        Assertions.assertEquals(price, item.getPrice());
        Assertions.assertEquals(testCategory, item.getCategory());
        Assertions.assertEquals(loyaltyPoints, item.getLoyaltyPoints());
    }

    @Test
    public void copy_entityCopied_allFieldsAreAssigned() {
        String name = "Test";
        int id = 1;
        float price = 100.5F;
        String testCategory = "test category";
        int loyaltyPoints = 10;

        StandardItem item = new StandardItem(id, name, price, testCategory, loyaltyPoints).copy();

        Assertions.assertEquals(id, item.getID());
        Assertions.assertEquals(name, item.getName());
        Assertions.assertEquals(price, item.getPrice());
        Assertions.assertEquals(testCategory, item.getCategory());
        Assertions.assertEquals(loyaltyPoints, item.getLoyaltyPoints());
    }

    @ParameterizedTest(name = "Test objects equality")
    @CsvSource({
            "Test, 1, 100.5, testcategory, 10,Test, 1, 100.5, testcategory, 10, true",
            "Test, 1, 100.5, testcategory, 10,Test, 1, 100.4, testcategory, 10, false",
            "Test, 1, 100.5, testcategory, 10,Test, 1, 100.5, testcategory2, 10, false"
    })
    public void equals_AandB_areEqual(String name1, int id1, float price1, String testCategory1, int loyaltyPoints1, String name2, int id2, float price2, String testCategory2, int loyaltyPoints2, boolean expectedResult) {
        StandardItem item1 = new StandardItem(id1, name1, price1, testCategory1, loyaltyPoints1);
        StandardItem item2 = new StandardItem(id2, name2, price2, testCategory2, loyaltyPoints2);
        Assertions.assertEquals(expectedResult, item1.equals(item2));
    }
}
