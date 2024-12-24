package org.lessons.mock;

import java.util.List;
import org.lessons.domain.Answers;

public class AnswersMock {

  public static Answers getAnswers() {
    return new Answers(List.of(1, 2));
  }

}
