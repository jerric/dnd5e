package net.lliira.dnd5e.common.util;

import java.util.Random;
import java.util.regex.Pattern;

public class Dice {
    public static final Dice D4 = new Dice(4);
    public static final Dice D6 = new Dice(6);
    public static final Dice D20 = new Dice(20);
    public static final Dice D100 = new Dice(100);

    private static final Pattern PATTERN = Pattern.compile("(\\d+)D(\\d+)((\\+|-)(\\d+))?");

    private transient final Random random;
    private int sides;
    private int count;
    private int modifier;

    public Dice() {
        this(new Random(), 1, 1, 0);
    }

    public Dice(String dice) {
        var matcher = PATTERN.matcher(dice.toUpperCase());
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid Dice pattern: " + dice);
        }
        random = new Random();
        count = Integer.parseInt(matcher.group(1));
        sides = Integer.parseInt(matcher.group(2));
        if (matcher.group(3) != null) {
            int sign = matcher.group(4).equals("+") ? 1 : -1;
            modifier = sign * Integer.parseInt(matcher.group(5));
        }
    }

    public Dice(int sides) {
        this(new Random(), sides, 1, 0);
    }

    public Dice(int sides, int count) {
        this(new Random(), sides, count, 0);
    }

    public Dice(int sides, int count, int modifier) {
        this(new Random(), sides, count, modifier);
    }

    public Dice(Random random, int sides, int count, int modifier) {
        this.random = random;
        this.sides = sides;
        this.count = count;
        this.modifier = modifier;
    }

    public int getSides() {
        return sides;
    }

    public int getCount() {
        return count;
    }

    public int getModifier() {
        return modifier;
    }

    public int roll() {
        if (sides < 1) throw new IllegalArgumentException("Dice must have at least 1 side.");
        if (count < 1) throw new IllegalArgumentException("Must roll at least 1 dice");

         int sum = 0;
        for(int i = 0; i < count; i++) {
            sum += random.nextInt(sides) + 1;
        }
        return sum + modifier;
    }
}
