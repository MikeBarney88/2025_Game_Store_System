package com.keyin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void testCreateValidGame() {
        Game gameUnderTest = new Game("Escape From Tarkov", 159.99, 15);

        Assertions.assertEquals("Escape From Tarkov", gameUnderTest.getTitle());
        Assertions.assertEquals(159.99, gameUnderTest.getPrice(), 0.01);
        Assertions.assertEquals(15, gameUnderTest.getStock());
    }

    @Test
    public void testDecreaseStockReducesQuantity() {
        Game gameUnderTest = new Game("Arena Breakout Infinite", 59.99, 10);

        gameUnderTest.decreaseStock(3);

        Assertions.assertTrue(gameUnderTest.getStock() == 7);
    }

    @Test
    public void testNegativePriceThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Game("Bad Game", -10.0, 5);
        });
    }
}
