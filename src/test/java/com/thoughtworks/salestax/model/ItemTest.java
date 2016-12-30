package com.thoughtworks.salestax.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    @Test
    void constructorProperlySetsBooleans() {
        Item item = new Item("imported chocolate", 10.00, 1);

        assertArrayEquals(new Boolean[] {item.isTaxable(), item.isImported()}, new Boolean[] {false, true});
    }

    @Test
    void calculateTaxCalculatesProperly() {
        double tax = .1;
        double importTax = .05;
        Item taxableItem = new Item("taxable", 10.00, 1);
        Item importedItem = new Item("imported chocolate", 10.00, 1);
        Item bothItem = new Item("imported taxable", 10.00, 1);
        Item neitherItem = new Item("chocolate", 10.00, 1);

        taxableItem.calculateTax(tax, importTax);
        importedItem.calculateTax(tax, importTax);
        bothItem.calculateTax(tax, importTax);
        neitherItem.calculateTax(tax, importTax);

        assertArrayEquals(new double[]{taxableItem.getTax(), importedItem.getTax(), bothItem.getTax(), neitherItem.getTax()},
                          new double[]{1.0, 0.5, 1.5, 0.0});
    }
}