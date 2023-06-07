package org.example.entity;

public class HouseholdEntity {
    private int id;
    private String name;
    private String category;
    private double price;
    private int quantity;

    public HouseholdEntity(int id, String name, String category, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("%-5d%-20s%-20s%8.2f%5d", id, name, category, price, quantity);
    }
}
