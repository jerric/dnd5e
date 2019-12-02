package net.lliira.dnd5e.common.creature.career;

import net.lliira.dnd5e.common.util.Dice;

import java.util.List;

/** The synonym for Class (Class is a reserved word). */
public class Career {
  private String name;
  private Dice hitDice;
  private int hpBase;
  private Proficiency proficiency;
  private List<Integer> proficiencyBonuses;
  private List<Integer> cantripSlots;
  private List<Integer> spellLevel1Slots;
  private List<Integer> spellLevel2Slots;
  private List<Integer> spellLevel3Slots;
  private List<Integer> spellLevel4Slots;
  private List<Integer> spellLevel5Slots;
  private List<Integer> spellLevel6Slots;
  private List<Integer> spellLevel7Slots;
  private List<Integer> spellLevel8Slots;
  private List<Integer> spellLevel9Slots;

  public String getName() {
    return name;
  }
}
