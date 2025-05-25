package org;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void testValidCart() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("item1", 2, 100, 0.1));
        String cardNumber = "1234567890123456";
        double result = SILab2.checkCart(items, cardNumber);
        assertEquals(180.0, result, 0.01);
    }

    @Test
    void testNullItems() {
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(null, "1234567890123456"));
    }

    @Test
    void testMultipleCondition() {
        // Case 1: false || false || false
        Item item1 = new Item("item1", 1, 100, 0.0); // Price <= 300, Discount = 0, Quantity <= 10
        List<Item> items1 = new ArrayList<>();
        items1.add(item1);
        assertEquals(100.0, SILab2.checkCart(items1, "1234567890123456"));

        // Case 2: false || false || true
        Item item2 = new Item("item2", 11, 100, 0.0); // Price <= 300, Discount = 0, Quantity > 10
        List<Item> items2 = new ArrayList<>();
        items2.add(item2);
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(items2, "1234567890123456"));

        // Case 3: false || true || false
        Item item3 = new Item("item3", 1, 100, 0.1); // Price <= 300, Discount > 0, Quantity <= 10
        List<Item> items3 = new ArrayList<>();
        items3.add(item3);
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(items3, "1234567890123456"));

        // Case 4: false || true || true
        Item item4 = new Item("item4", 11, 100, 0.1); // Price <= 300, Discount > 0, Quantity > 10
        List<Item> items4 = new ArrayList<>();
        items4.add(item4);
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(items4, "1234567890123456"));

        // Case 5: true || false || false
        Item item5 = new Item("item5", 1, 400, 0.0); // Price > 300, Discount = 0, Quantity <= 10
        List<Item> items5 = new ArrayList<>();
        items5.add(item5);
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(items5, "1234567890123456"));

        // Case 6: true || false || true
        Item item6 = new Item("item6", 11, 400, 0.0); // Price > 300, Discount = 0, Quantity > 10
        List<Item> items6 = new ArrayList<>();
        items6.add(item6);
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(items6, "1234567890123456"));

        // Case 7: true || true || false
        Item item7 = new Item("item7", 1, 400, 0.1); // Price > 300, Discount > 0, Quantity <= 10
        List<Item> items7 = new ArrayList<>();
        items7.add(item7);
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(items7, "1234567890123456"));

        // Case 8: true || true || true
        Item item8 = new Item("item8", 11, 400, 0.1); // Price > 300, Discount > 0, Quantity > 10
        List<Item> items8 = new ArrayList<>();
        items8.add(item8);
        assertThrows(RuntimeException.class, () -> SILab2.checkCart(items8, "1234567890123456"));
    }

}
