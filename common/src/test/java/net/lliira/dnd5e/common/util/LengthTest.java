package net.lliira.dnd5e.common.util;

import org.junit.Assert;
import org.junit.Test;

public class LengthTest {

  @Test
  public void testPattern() {
    assertLength(1, 5, new Length("1'5\""));
    assertLength(3, 0, new Length("3'"));
    assertLength(0, 6, new Length("6\""));
  }

  @Test
  public void testNormalize() {
    assertLength(1, 3, new Length("15\""));
    assertLength(2, 5, new Length("1'17\""));
    assertLength(4, 1, new Length(3, 13));
    assertLength(1, 6, new Length(0, 18));
    assertLength(0, 0, new Length(0, -20));
    assertLength(0, 0, new Length(-1, 10));
  }

  @Test
  public void testAdd() {
    assertLength(1, 11, new Length(1, 2).add(9));
    assertLength(2, 4, new Length(1, 6).add(10));
    assertLength(1, 5, new Length(1, 8).add(-3));
    assertLength(0, 10, new Length(1, 8).add(-10));
    assertLength(4, 2, new Length(1, 8).add(30));
    assertLength(0, 0, new Length(1, 8).add(-20));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testinvalidPattern1() {
    new Length("101");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testinvalidPattern2() {
    new Length("-101'");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testinvalidPattern3() {
    new Length("25'12");
  }

  private static void assertLength(int foot, int inch, Length actual) {
    Assert.assertEquals(foot, actual.getFoot());
    Assert.assertEquals(inch, actual.getInch());
  }
}
