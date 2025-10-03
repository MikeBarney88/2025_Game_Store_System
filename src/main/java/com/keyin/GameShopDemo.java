package com.keyin;

import java.sql.SQLOutput;

public class GameShopDemo {

    public static void main(String[] args) {
        System.out.println(" Game Shop Demo");

        GameShop shop = new GameShop();

        Game EFT = new Game(" Escape From Tarkov", 159.99, 15);
        Game ABI = new Game(" Arena Breakout Infinite", 59.99, 10);
        Game Minecraft = new Game(" Minecraft", 19.99, 5);

        shop.addGame(EFT);
        shop.addGame(Minecraft);
        shop.addGame(ABI);

        System.out.println(" Games in shop: " + shop.getInventorySize());

        System.out.println("\n Available Games:");
        Game[] allGames = shop.browseGames();
        for (int i = 0; i < allGames.length; i++) {
            System.out.printf(" - %s: $%.2f (Stock: %d)%n",
                    allGames[i].getTitle(), allGames[i].getPrice(), allGames[i].getStock());
        }

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addGame(ABI);
        shoppingCart.addGame(EFT);

        System.out.println("\n Cart:");
        System.out.println(" Items: " + shoppingCart.getItemCount());
        System.out.printf(" Total: $%.2f%n", shoppingCart.getTotal());

        System.out.println("\n Processing purchase . . .");
        shop.purchase(shoppingCart);
        System.out.println("\n Purchase successful!");

        System.out.println("\n Updated stock:");
        System.out.println(" Arena Breakout Infinite stock: " + ABI.getStock());
        System.out.println(" Escape From Tarkov stock: " + EFT.getStock());
    }
}
