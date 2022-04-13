package archive;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import shop.Order;

import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

public class PurchasesArchiveTest {
    @Mock
    Order orderMock;

    @Mock
    ItemPurchaseArchiveEntry itemEntry;

    private HashMap<Integer, ItemPurchaseArchiveEntry> itemArchive;
    private ArrayList<Order> orderArchive;
    private PurchasesArchive archive;

    @BeforeEach
    public void setup() {
        itemArchive = new HashMap<>();
        itemArchive.put(2, itemEntry);
        orderArchive = new ArrayList<>();
        orderArchive.add(orderMock);
        archive = new PurchasesArchive(itemArchive, orderArchive);
    }

    @Test
    public void test() {
        try (MockedConstruction mocked = mockConstruction(ItemPurchaseArchiveEntry.class)) {
//            ItemPurchaseArchiveEntry foo = new ItemPurchaseArchiveEntry();
//            when(foo.toString()).thenReturn("zasoby xy");
        }
    }
}
