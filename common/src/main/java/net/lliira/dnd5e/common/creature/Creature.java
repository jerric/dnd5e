package net.lliira.dnd5e.common.creature;

public abstract class Creature {

  private final Ability Strength;
  private final Ability Dexterity;
  private final Ability Constitution;
  private final Ability Intelligence;
  private final Ability Wisdom;
  private final Ability Charisma;

  private Creature(
      Ability strength,
      Ability dexterity,
      Ability constitution,
      Ability intelligence,
      Ability wisdom,
      Ability charisma) {
    Strength = strength;
    Dexterity = dexterity;
    Constitution = constitution;
    Intelligence = intelligence;
    Wisdom = wisdom;
    Charisma = charisma;
  }

  public Ability getStrength() {
    return Strength;
  }

  public Ability getDexterity() {
    return Dexterity;
  }

  public Ability getConstitution() {
    return Constitution;
  }

  public Ability getIntelligence() {
    return Intelligence;
  }

  public Ability getWisdom() {
    return Wisdom;
  }

  public Ability getCharisma() {
    return Charisma;
  }
}
