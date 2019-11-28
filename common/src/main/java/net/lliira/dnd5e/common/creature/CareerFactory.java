package net.lliira.dnd5e.common.creature;

import net.lliira.dnd5e.common.util.ResourceLoader;

import java.util.List;

public class CareerFactory {

  private final List<Career> careers;

  public CareerFactory() {
    careers = ResourceLoader.getResources("creature/career", Career.class);
  }

  public Career[] getCareers() {
    return careers.toArray(new Career[0]);
  }
}
