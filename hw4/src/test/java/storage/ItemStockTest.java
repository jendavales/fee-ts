package storage;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import shop.Item;
import shop.StandardItem;

public class ItemStockTest {
    private Item refItem = new StandardItem(1, "ponozky adidas", 5, "ponozky", 5);

    @Test
    public void constructor_entityCreated_allFieldsAreAssigned() {
        ItemStock item = new ItemStock(refItem);
        Assertions.assertEquals(refItem, item.getItem());
        Assertions.assertEquals(0, item.getCount());
    }

    @ParameterizedTest(name = "Item stock count increased by {0}")
    @CsvSource({"10", "20", "-10", "0"})
    public void increaseCount_increaseByValue_countIsIncreased(int increaseValue) {
        ItemStock item = new ItemStock(refItem);
        item.IncreaseItemCount(increaseValue);
        Assertions.assertEquals(increaseValue, item.getCount());
    }

    @ParameterizedTest(name = "Item stock count decreased by {0}")
    @CsvSource({"10", "20", "-10", "0"})
    public void decreaseCount_decreaseByValue_countIsDecreased(int increaseValue) {
        ItemStock item = new ItemStock(refItem);
        item.decreaseItemCount(increaseValue);
        Assertions.assertEquals(-increaseValue, item.getCount());
    }
}
