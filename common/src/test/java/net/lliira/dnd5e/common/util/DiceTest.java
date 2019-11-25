package net.lliira.dnd5e.common.util;

import org.junit.Assert;
import org.junit.Test;

public class DiceTest {

    private static final int ITERATION = 1000;
    @Test
    public void testSides() {
        for (int i = 0; i < ITERATION; i++) {
            assertInRange(Dice.D4.roll(), 1, 4);
            assertInRange(Dice.D6.roll(), 1, 6);
            assertInRange(Dice.D20.roll(), 1, 20);
            assertInRange(Dice.D100.roll(), 1, 100);
            assertInRange(Dice.D(10).roll(), 1, 10);
        }
    }

    @Test
    public void testCount() {
        for (int i = 0; i < ITERATION; i++) {
            assertInRange(Dice.D6.roll(1, 0), 1, 6);
            assertInRange(Dice.D6.roll(2, 0), 2, 12);
            assertInRange(Dice.D6.roll(3, 0), 3, 18);
            assertInRange(Dice.D6.roll(4, 0), 4, 24);
            assertInRange(Dice.D6.roll(5, 0), 5, 30);
        }
    }

    @Test
    public void testModifier() {
        for (int i = 0; i < ITERATION; i++) {
            assertInRange(Dice.D20.roll(1, -1), 0, 19);
            assertInRange(Dice.D6.roll(1, 3), 4, 9);
            assertInRange(Dice.D(5).roll(1, 6), 6, 11);
            assertInRange(Dice.D(8).roll(1, -4), -2, 24);
        }
    }

    @Test
    public void testCombination() {
        for (int i = 0; i < ITERATION; i++) {
            assertInRange(Dice.D6.roll(2, -1), 1, 11);
            assertInRange(Dice.D6.roll(3, 3), 6, 21);
            assertInRange(Dice.D4.roll(3, -3), 0, 9);
            assertInRange(Dice.D(8).roll(2, 5), 7, 21);
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSides() {
        Dice.D(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCount() {
        Dice.D6.roll(0, 0);
    }

    private static void assertInRange(int actual, int expectedFrom, int expectedTo) {
        Assert.assertTrue(actual >= expectedFrom &&actual <= expectedTo);
    }
}
