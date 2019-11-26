package net.lliira.dnd5e.common.creature;

public interface AbilityAdjustment {
    default int baseAdjustment() { return 0; }
}
