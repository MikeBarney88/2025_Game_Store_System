package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShoppingCartTest {

    @Test
    public void testAddGameToCart() {
        ShoppingCart cartUnderTest = new ShoppingCart();
        Game gameUnderTest = new Game("Escape From Tarkov", 159.99, 15);

        cartUnderTest.addGame(gameUnderTest);

        Assertions.assertTrue(cartUnderTest.getItemCount() == 1);
    }

    @Test
    public void testRemoveGameFromCart() {
        ShoppingCart cartUnderTest = new ShoppingCart();
        Game gameUnderTest = new Game("Arena Breakout Infinite", 59.99, 10);

        cartUnderTest.addGame(gameUnderTest);
        cartUnderTest.removeGame(gameUnderTest);

        Assertions.assertTrue(cartUnderTest.getItemCount() == 0);
    }

    @Test
    public void testCalculateTotalWithMultipleGames() {
        ShoppingCart cartUnderTest = new ShoppingCart();
        Game gameUnderTest1 = new Game("Escape From Tarkov", 159.99, 15);
        Game gameUnderTest2 = new Game("Minecraft", 19.99, 5);

        cartUnderTest.addGame(gameUnderTest1);
        cartUnderTest.addGame(gameUnderTest2);

        Assertions.assertEquals(179.98, cartUnderTest.getTotal(), 0.01);
    }

    @Test
    public void testAddNullGameThrowsException() {
        ShoppingCart cartUnderTest = new ShoppingCart();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            cartUnderTest.addGame(null);
        });
    }
}