package com.thoughtworks.salestax.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    @Test
    void createReceiptWritesProperReceipt() {
        ShoppingCart cart = new ShoppingCart();
        Item item = new Item("imported chocolate", 10.00, 1);
        Item item2 = new Item("perfume", 10.00, 1);
        cart.addItem(item);
        cart.addItem(item2);
        double tax = 0.1;
        double importTax = 0.05;
        cart.createReceipt(tax, importTax);

        Receipt receipt = cart.getReceipt();

        assertTrue(receipt.getText().equals("1 imported chocolate: 10.50\r\n" +
                                  "1 perfume: 11.00\r\n" +
                                  "Sales Taxes: 1.50\r\n" +
                                  "Total: 21.50"));
    }
}