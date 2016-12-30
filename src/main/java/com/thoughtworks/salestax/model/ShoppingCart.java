package com.thoughtworks.salestax.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> items;
    private Receipt receipt;

    public ShoppingCart() {
        items = new ArrayList<>();
        receipt = new Receipt();
    }

    public List<Item> getItems() {
        return items;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Creates the receipt for the shopping cart
     * @param standardTax The standard tax rate
     * @param importTax The import tax rate
     */
    public void createReceipt(double standardTax, double importTax) {
        double tax = 0.0;
        double total = 0.0;

        for(Item item: items) {
            item.calculateTax(standardTax, importTax);
            tax += item.getTax();
            total += (item.getPrice() + item.getTax());
            receipt.setText(receipt.getText() + String.format("%d %s: %.2f%n",
                    item.getQuantity(),
                    item.getName(),
                    item.getPrice() + item.getTax()));
        }

        receipt.setText(receipt.getText() + String.format("Sales Taxes: %.2f%n" +
                "Total: %.2f", tax, total));
    }
}
