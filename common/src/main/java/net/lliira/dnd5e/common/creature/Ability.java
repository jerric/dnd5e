package net.lliira.dnd5e.common.creature;

import java.util.HashSet;
import java.util.Set;

public class Ability {

  private static final int MIN_SCORE = 1;
  private static final int MAX_SCORE = 30;

  private final Set<AttributeAdjustment> adjustments;
  private int baseScore_;

  protected Ability(int baseScore) {
    validateBaseScore(baseScore);
    this.baseScore_ = baseScore;
    this.adjustments = new HashSet<>();
  }

  public void setBaseScore(int baseScore) {
    validateBaseScore(baseScore);
    this.baseScore_ = baseScore;
  }

  public void registerAdjustment(AttributeAdjustment adjustment) {
    adjustments.add(adjustment);
  }

  public void unregisterAdjustment(AttributeAdjustment adjustment) {
    adjustments.remove(adjustment);
  }

  public int getScore() {
    int score = baseScore_;
    for (var adjustment : adjustments) {
      score += adjustment.getScore();
    }
    return Math.max(score, MIN_SCORE);
  }

  public int getModifier() {
    return getScore() / 2 - 5;
  }

  private void validateBaseScore(int baseScore) {
    if (baseScore < MIN_SCORE || baseScore > MAX_SCORE)
      throw new IllegalArgumentException(
          String.format("Ability score is out of range of [%d, %d]", MIN_SCORE, MAX_SCORE));
  }
}
