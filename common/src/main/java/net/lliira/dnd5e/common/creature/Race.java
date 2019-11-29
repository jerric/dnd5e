package net.lliira.dnd5e.common.creature;

import net.lliira.dnd5e.common.util.Dice;
import net.lliira.dnd5e.common.util.Length;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private String name;
    private Length baseHeight;
    private Dice heightModifier;
    private int baseWeight;
    private Dice weightModifier;
    private List<AbilityAdjustment> abilityAdjustments = new ArrayList<>();
    private Age age;
    private List<Alignment> alignments = new ArrayList<>();
    private Size size;

    public String getName() {
        return name;
    }
}
