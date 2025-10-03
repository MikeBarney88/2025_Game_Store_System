package com.keyin;

public class Game {
    private String title;
    private double price;
    private int stock;

    public Game(String title, double price, int stock) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }

        this.title = title;
        this.price = price;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void decreaseStock(int amount) {
        if (amount > stock) {
            throw new IllegalArgumentException("Not enough stock");
        }
        stock -= amount;
    }

    public boolean isAvailable() {
        return stock > 0;
    }
}