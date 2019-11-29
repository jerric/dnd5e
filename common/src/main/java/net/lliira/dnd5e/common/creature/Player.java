package net.lliira.dnd5e.common.creature;


import net.lliira.dnd5e.common.util.Dice;

import java.util.HashMap;
import java.util.Map;

public class Player {
  private final Race race;
  private final Map<Proficiency, Integer> proficiencyBonuses;
  private Ability strength;
  private Ability dexterity;
  private Ability constitution;
  private Ability intelligence;
  private Ability wisdom;
  private Ability charisma;

  private Career career;
  private String name;
  private Gender gender;
  private String background;

  private int level;
  private long xp;
  private int maxHp;
  private int hp;
  private Dice hitDice;
  private int hitDiceCount;
  private Alignment alignment;
  private int age;

  public Player(Race race) {
    this.race = race;
    this.proficiencyBonuses = new HashMap<>();
  }
}
