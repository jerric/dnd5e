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
            assertInRange(new Dice(10).roll(), 1, 10);
        }
    }

    @Test
    public void testCount() {
        for (int i = 0; i < ITERATION; i++) {
            assertInRange(new Dice(6, 1).roll(), 1, 6);
            assertInRange(new Dice(6, 2).roll(), 2, 12);
            assertInRange(new Dice(6, 3).roll(), 3, 18);
            assertInRange(new Dice(6, 4).roll(), 4, 24);
            assertInRange(new Dice(6, 5).roll(), 5, 30);
        }
    }

    @Test
    public void testModifier() {
        for (int i = 0; i < ITERATION; i++) {
            assertInRange(new Dice(20, 1, -1).roll(), 0, 19);
            assertInRange(new Dice(6, 1, 3).roll(), 4, 9);
            assertInRange(new Dice(5, 1, 6).roll(), 6, 11);
            assertInRange(new Dice(8, 1, -4).roll(), -2, 24);
        }
    }

    @Test
    public void testCombination() {
        for (int i = 0; i < ITERATION; i++) {
            assertInRange(new Dice(6, 2, -1).roll(), 1, 11);
            assertInRange(new Dice(6, 3, 3).roll(), 6, 21);
            assertInRange(new Dice(4, 3, -3).roll(), 0, 9);
            assertInRange(new Dice(8, 2, 5).roll(), 7, 21);
        }
    }


    @Test
    public void testPattern() {
        for (int i = 0; i < ITERATION; i++) {
            assertInRange(new Dice("2D6-1").roll(), 1, 11);
            assertInRange(new Dice("3D6+3").roll(), 6, 21);
            assertInRange(new Dice("3D4-3").roll(), 0, 9);
            assertInRange(new Dice("2D8+5").roll(), 7, 21);
        }
    }


    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSides() {
        new Dice(0).roll();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCount() {
        new Dice(6, 0).roll();
    }

    private static void assertInRange(int actual, int expectedFrom, int expectedTo) {
        Assert.assertTrue(String.format("actual(%d) not in expected range [%d, %d]", actual, expectedFrom, expectedTo), actual >= expectedFrom &&actual <= expectedTo);
    }
}
