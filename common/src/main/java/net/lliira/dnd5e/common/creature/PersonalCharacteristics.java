package net.lliira.dnd5e.common.creature;

import java.util.ArrayList;
import java.util.List;

public class PersonalCharacteristics {
  private final List<String> traits;
  private final List<String> ideals;
  private final List<String> bonds;
  private final List<String> flaws;

  public PersonalCharacteristics() {
    traits = new ArrayList<>();
    ideals = new ArrayList<>();
    bonds = new ArrayList<>();
    flaws = new ArrayList<>();
  }
}
