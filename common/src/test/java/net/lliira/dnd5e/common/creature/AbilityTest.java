package net.lliira.dnd5e.common.creature;

import org.junit.Assert;
import org.junit.Test;

public class AbilityTest {

  @Test
  public void testModifier() {
    Assert.assertEquals(-5, new Ability(1).getModifier());
    Assert.assertEquals(-4, new Ability(2).getModifier());
    Assert.assertEquals(-4, new Ability(3).getModifier());
    Assert.assertEquals(-3, new Ability(4).getModifier());
    Assert.assertEquals(-3, new Ability(5).getModifier());
    Assert.assertEquals(-1, new Ability(9).getModifier());
    Assert.assertEquals(0, new Ability(10).getModifier());
    Assert.assertEquals(0, new Ability(11).getModifier());
    Assert.assertEquals(9, new Ability(28).getModifier());
    Assert.assertEquals(9, new Ability(29).getModifier());
    Assert.assertEquals(10, new Ability(30).getModifier());
  }
}
