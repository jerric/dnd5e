package net.lliira.dnd5e.common.util;

import java.util.Random;

public class Dice {
    public static final Dice D4 = new Dice(4);
    public static final Dice D6 = new Dice(6);
    public static final Dice D20 = new Dice(20);
    public static final Dice D100 = new Dice(100);

    public static final Dice D(int sides) {
        return new Dice(sides);
    }

    private final Random random_;
    private final int sides_;

    private Dice(int sides) {
        this(new Random(System.currentTimeMillis()), sides);
    }

    private Dice(Random random, int sides) {
        if (sides < 1) throw new IllegalArgumentException("Dice must have at least 1 side.");
        this.random_ = random;
        this.sides_ = sides;
    }

    public int roll() {
        return  roll(1, 0);
    }

    public int roll(int count, int modifier) {
        if (count < 1) throw new IllegalArgumentException("Must roll at least 1 dice");
        int sum = 0;
        for(int i = 0; i < count; i++) {
            sum += random_.nextInt(sides_) + 1;
        }
        return sum + modifier;
    }
}
