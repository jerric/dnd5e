package net.lliira.dnd5e.common.creature;

import net.lliira.dnd5e.common.util.Dice;
import net.lliira.dnd5e.common.util.Length;

public class Race {
    private String name;
    private Length baseHeight;
    private Dice heightModifier;
    private int baseWeight;
    private Dice weightModifier;

    public String getName() {
        return name;
    }
}
