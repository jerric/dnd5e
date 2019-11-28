package net.lliira.dnd5e.common.creature;


import net.lliira.dnd5e.common.util.Dice;

import java.util.HashMap;
import java.util.Map;

public class Player {
  private final Race race;
  private final Map<Proficiency, Integer> proficiencyBonuses;
  private Ability Strength;
  private Ability Dexterity;
  private Ability Constitution;
  private Ability Intelligence;
  private Ability Wisdom;
  private Ability Charisma;

  private Career career;
  private String name;
  private Gender gender;
  private String background;

  private int level;
  private long experimentPoints;
  private int hitPoints;
  private Dice hitDice;
  private int hitDiceCount;
  private Alignment alignment;

  public Player(Race race) {
    this.race = race;
    this.proficiencyBonuses = new HashMap<>();
  }
}
