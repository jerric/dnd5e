package net.lliira.dnd5e.common.creature.race;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class RaceFactoryTest {

  private static final Set<String> NAMES =
      Set.of(
          "Human",
          "Lightfoot Halfling",
          "Stout Halfling",
          "High Elf",
          "Wood Elf",
          "Hill Dwarf",
          "Mountain Dwarf");

  private final RaceFactory raceFactory = new RaceFactory();

  @Test
  public void testGetRaces() {
    var races = raceFactory.getRaces();
    Assert.assertEquals(7, races.length);
    for (var race : races) {
      Assert.assertTrue(NAMES.contains(race.getName()));
    }
  }
}
