package net.lliira.dnd5e.common.creature.career;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class CareerFactoryTest {

  private static final Set<String> NAMES = Set.of("Bard");

  private final CareerFactory careerFactory = new CareerFactory();

  @Test
  public void testGetCareers() {
    var careers = careerFactory.getCareers();
    Assert.assertEquals(1, careers.length);
    for (var career : careers) {
      Assert.assertTrue(NAMES.contains(career.getName()));
    }
  }
}
