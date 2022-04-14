package hw4.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderTest {
    @Test
    public void constructor_entityCreated_allFieldsAreAssigned() {
        ShoppingCart cart = new ShoppingCart();
        String customerName = "jmeno";
        String customerAddress = "adresa";
        int state = 5;

        Order order = new Order(cart, customerName, customerAddress, state);

        Assertions.assertEquals(customerName, order.getCustomerName());
        Assertions.assertEquals(customerAddress, order.getCustomerAddress());
        Assertions.assertEquals(state, order.getState());
    }

    @Test
    public void constructorNoState_entityCreated_allFieldsAreAssigned() {
        ShoppingCart cart = new ShoppingCart();
        String customerName = "jmeno";
        String customerAddress = "adresa";

        Order order = new Order(cart, customerName, customerAddress);

        Assertions.assertEquals(customerName, order.getCustomerName());
        Assertions.assertEquals(customerAddress, order.getCustomerAddress());
        Assertions.assertEquals(0, order.getState());
    }
}
