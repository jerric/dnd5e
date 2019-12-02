package net.lliira.dnd5e.common.creature.race;

import net.lliira.dnd5e.common.util.ResourceLoader;

import java.util.List;

public class RaceFactory {
  private final List<Race> races;

  public RaceFactory() {
    races = ResourceLoader.getResources("creature/race", Race.class);
  }

  public Race[] getRaces() {
    return races.toArray(new Race[0]);
  }
}
