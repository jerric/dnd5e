package net.lliira.dnd5e.common.util;

public class Length {
  private static final String FOOT_ONLY_PATTERN = "\\d+'";
  private static final String INCH_ONLY_PATTERN = "\\d+\"";
  private static final String FOOT_INCH_PATTERN = "\\d+'\\d+\"";

  private int foot;
  private int inch;

  public Length() {
    this(0, 0);
  }

  public Length(int foot, int inch) {
    this.foot = foot;
    this.inch = inch;
    normalize();
  }

  public Length(String length) {
    if (length.matches(FOOT_ONLY_PATTERN)) {
      foot = Integer.parseInt(length.substring(0, length.length() - 1));
    } else if (length.matches(INCH_ONLY_PATTERN)) {
      inch = Integer.parseInt(length.substring(0, length.length() - 1));
    } else if (length.matches(FOOT_INCH_PATTERN)) {
      String[] parts = length.split("['\"]");
      foot = Integer.parseInt(parts[0]);
      inch = Integer.parseInt(parts[1]);
    } else {
      throw new IllegalArgumentException("Length pattern is invalid: " + length);
    }
    normalize();
  }

  public Length add(int inch) {
    this.inch += inch;
    normalize();
    return this;
  }

  public int getFoot() {
    return foot;
  }

  public int getInch() {
    return inch;
  }

  private void normalize() {
    int sign = inch >= 0 ? 1 : -1;
    while(inch < 0 || inch >= 12) {
      foot += sign;
      inch -= sign * 12;
    }
    if (foot < 0) {
      foot = inch = 0;
    }
  }
}
