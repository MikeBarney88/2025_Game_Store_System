package com.keyin;

public class GameShop {
    private Game[] inventory;
    private int gameCount;

    public GameShop() {
        this.inventory = new Game[50];
        this.gameCount = 0;
    }

    public void addGame(Game game) {
        if (game == null) {
            throw new IllegalArgumentException("Game cannot be null");
        }
        if (gameCount >= 50) {
            throw new IllegalArgumentException("Inventory is full");
        }

        inventory[gameCount] = game;
        gameCount++;
    }

    public Game[] browseGames() {
        Game[] result = new Game[gameCount];
        for (int i = 0; i < gameCount; i++) {
            result[i] = inventory[i];
        }
        return result;
    }

    public Game findGame(String title) {
        for (int i = 0; i < gameCount; i++) {
            if (inventory[i].getTitle().equalsIgnoreCase(title)) {
                return inventory[i];
            }
        }
        return null;
    }

    public boolean purchase(ShoppingCart shoppingcart) {
        if (shoppingcart == null || shoppingcart.isEmpty()) {
            throw new IllegalArgumentException("Cart is empty");
        }

        Game[] cartGames = shoppingcart.getGames();

        for (Game cartGame : cartGames) {
            if (!cartGame.isAvailable()) {
                throw new IllegalArgumentException("Game not available: " + cartGame.getTitle());
            }
        }

        for (Game cartGame : cartGames) {
            cartGame.decreaseStock(1);
        }

        return true;
    }

    public int getInventorySize() {
        return gameCount;
    }
}
