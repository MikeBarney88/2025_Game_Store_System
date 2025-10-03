package com.keyin;

public class ShoppingCart {
    private Game[] games;
    private int itemCount;

    public ShoppingCart() {
        this.games = new Game[10];
        this.itemCount = 0;
    }

    public void addGame(Game game) {
        if (game == null) {
            throw new IllegalArgumentException("Game cannot be null");
        }
        if (!game.isAvailable()) {
            throw new IllegalArgumentException("Game is not available");
        }
        if (itemCount >= 10) {
            throw new IllegalArgumentException("Cart is full");
        }

        games[itemCount] = game;
        itemCount++;
    }

    public void removeGame(Game game) {
        int index = -1;
        for (int i = 0; i < itemCount; i++) {
            if (games[i] == game) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            throw new IllegalArgumentException("Game not in cart");
        }

        for (int i = index; i < itemCount - 1; i++) {
            games[i] = games[i + 1];
        }
        games[itemCount - 1] = null;
        itemCount--;
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += games[i].getPrice();
        }
        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public boolean isEmpty() {
        return itemCount == 0;
    }

    public Game[] getGames() {
        Game[] result = new Game[itemCount];
        for (int i = 0; i < itemCount; i++) {
            result[i] = games[i];
        }
        return result;
    }

    public void clear() {
        for (int i = 0; i < itemCount; i++) {
            games[i] = null;
        }
        itemCount = 0;
    }
}