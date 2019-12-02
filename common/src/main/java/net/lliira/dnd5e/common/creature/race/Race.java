package net.lliira.dnd5e.common.creature.race;

import net.lliira.dnd5e.common.creature.Age;
import net.lliira.dnd5e.common.creature.Alignment;
import net.lliira.dnd5e.common.creature.AttributeAdjustment;
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
  private Age age;
  private List<Alignment> alignments = new ArrayList<>();
  private Size size;
  private int speed;
  private Vision vision;
  private List<Language> languages = new ArrayList<>();
  private AttributeAdjustment strengthAdjustment;
  private AttributeAdjustment dexterityAdjustment;
  private AttributeAdjustment constitutionAdjustment;
  private AttributeAdjustment intelligenceAdjustment;
  private AttributeAdjustment wisdomAdjustment;
  private AttributeAdjustment charismaAdjustment;
  private AttributeAdjustment hpAdjustment;

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return name;
  }
}
