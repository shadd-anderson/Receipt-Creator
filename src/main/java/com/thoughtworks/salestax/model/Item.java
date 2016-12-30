package com.thoughtworks.salestax.model;

import static com.thoughtworks.salestax.util.Constants.EXCLUDED_ITEMS;

public class Item {
    private String name;
    private double price;
    private double tax;
    private boolean imported;
    private boolean taxable;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        imported = name.contains("imported");
        taxable = true;
        for (String excludedItem: EXCLUDED_ITEMS) {
            if (name.contains(excludedItem)) {
                taxable = false;
                break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    /**
     * Calculates the tax of the item
     * @param standardTax - The standard tax rate
     * @param importTax - The tax rate for imported goods
     */
    public void calculateTax(double standardTax, double importTax) {
        double itemTax = 0.0;

        if (taxable) {
            itemTax = Math.ceil(price * quantity * 20.0 * standardTax) / 20.0;
        }
        if (imported) {
            itemTax = itemTax + Math.ceil(price * quantity * 20.0 * importTax) / 20.0;
        }

        tax = itemTax;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (Double.compare(item.price, price) != 0) return false;
        if (imported != item.imported) return false;
        if (taxable != item.taxable) return false;
        if (quantity != item.quantity) return false;
        return name.equals(item.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(tax);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (imported ? 1 : 0);
        result = 31 * result + (taxable ? 1 : 0);
        result = 31 * result + quantity;
        return result;
    }
}
