package org.lessons.domain.enums;

import java.util.Arrays;

public enum AnswerType {
  Multiple("multiple"),
  Single("single");

  private final String title;

  AnswerType(String title) {
    this.title = title;
  }

  public static AnswerType getType(String title) {
    return Arrays.stream(AnswerType.values()).filter(t -> t.title.equals(title)).findFirst()
        .orElse(null);
  }
}
