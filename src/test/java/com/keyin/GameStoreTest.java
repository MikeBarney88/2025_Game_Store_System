package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GameStoreTest {

    @Test
    public void testAddGameToStore() {
        GameShop shopUnderTest = new GameShop();
        Game gameUnderTest = new Game("Escape From Tarkov", 159.99, 15);

        shopUnderTest.addGame(gameUnderTest);

        Assertions.assertTrue(shopUnderTest.getInventorySize() == 1);
    }

    @Test
    public void testFindGameByTitle() {
        GameShop storeUnderTest = new GameShop();
        Game gameUnderTest = new Game("Arena Breakout Infinite", 59.99, 10);

        storeUnderTest.addGame(gameUnderTest);
        Game foundGame = storeUnderTest.findGame("Arena Breakout Infinite");

        Assertions.assertNotNull(foundGame);
        Assertions.assertEquals("Arena Breakout Infinite", foundGame.getTitle());
    }

    @Test
    public void testPurchaseDecreasesStock() {
        GameShop storeUnderTest = new GameShop();
        Game gameUnderTest = new Game("Minecraft", 19.99, 5);
        ShoppingCart cartUnderTest = new ShoppingCart() ;

        storeUnderTest.addGame(gameUnderTest);
        cartUnderTest.addGame(gameUnderTest);

        storeUnderTest.purchase(cartUnderTest);

        Assertions.assertTrue(gameUnderTest.getStock() == 4);
    }

    @Test
    public void testPurchaseWithEmptyCartThrowsException() {
        GameShop storeUnderTest = new GameShop();
        ShoppingCart cartUnderTest = new ShoppingCart();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            storeUnderTest.purchase(cartUnderTest);
        });
    }
}