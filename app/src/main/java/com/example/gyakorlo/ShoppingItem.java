package com.example.gyakorlo;

public class ShoppingItem {
    private String name;
    private int quantity;

    public ShoppingItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }
}
