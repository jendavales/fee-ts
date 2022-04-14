package hw4.archive;

import hw4.shop.Item;
import hw4.shop.StandardItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import hw4.shop.Order;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.mockito.Mockito.*;

public class PurchasesArchiveTest {
    @Mock
    Order orderMock;

    @Mock
    ItemPurchaseArchiveEntry itemEntryMock;

    private HashMap<Integer, ItemPurchaseArchiveEntry> itemArchive;
    private ArrayList<Order> orderArchive;
    private PurchasesArchive archive;

    @BeforeEach
    public void setup() {
        orderMock = mock(Order.class);
        itemEntryMock = mock(ItemPurchaseArchiveEntry.class);
        itemArchive = new HashMap<>();
        itemArchive.put(1, itemEntryMock);
        orderArchive = new ArrayList<>();
        orderArchive.add(orderMock);
        archive = new PurchasesArchive(itemArchive, orderArchive);
        when(itemEntryMock.getCountHowManyTimesHasBeenSold()).thenReturn(5);
        when(itemEntryMock.toString()).thenReturn("Mockovana hlaska");
    }

    @Test
    public void getHowManyTimesHasBeenItemSold_itemHasBeenSold_countReturned() {
        Item itemForStats = new StandardItem(1, "a", 1, "a", 1);
        Assertions.assertEquals(5, archive.getHowManyTimesHasBeenItemSold(itemForStats));
    }

    @Test
    public void getHowManyTimesHasBeenItemSold_differentItem_zeroReturned() {
        Item itemForStats = new StandardItem(2, "a", 1, "a", 1);
        Assertions.assertEquals(0, archive.getHowManyTimesHasBeenItemSold(itemForStats));
    }

    @Test
    public void printItemPurchaseStatistics_print_statsArePrintedToOutput() {
        final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        archive.printItemPurchaseStatistics();
        Assertions.assertEquals("ITEM PURCHASE STATISTICS:\r\n" +
                "Mockovana hlaska\r\n", outputStreamCaptor.toString());
    }

    @Test
    public void putOrderToPurchasesArchive_newItem_itemsCountIncreases() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new StandardItem(3, "a", 1, "a", 1));
        when(orderMock.getItems()).thenReturn(items);
        archive.putOrderToPurchasesArchive(orderMock);
        Assertions.assertEquals(1, archive.getHowManyTimesHasBeenItemSold(items.get(0)));
    }

    @Test
    public void putOrderToPurchasesArchive_existingItem_soldCountIncreases() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new StandardItem(1, "a", 1, "a", 1));
        when(orderMock.getItems()).thenReturn(items);
        archive.putOrderToPurchasesArchive(orderMock);
        verify(itemEntryMock, times(1)).increaseCountHowManyTimesHasBeenSold(1);
    }

    @Test
    public void putOrderToPurchasesArchive_otherItemIsAdded_countStays() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new StandardItem(3, "a", 1, "a", 1));
        when(orderMock.getItems()).thenReturn(items);
        archive.putOrderToPurchasesArchive(orderMock);
        StandardItem otherItem = new StandardItem(2, "a", 1, "a", 0);
        Assertions.assertEquals(0, archive.getHowManyTimesHasBeenItemSold(otherItem));
    }
}
