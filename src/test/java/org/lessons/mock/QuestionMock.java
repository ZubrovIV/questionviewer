package org.lessons.mock;

import java.util.HashSet;
import java.util.List;
import org.lessons.domain.Question;
import org.lessons.domain.enums.AnswerType;

public class QuestionMock {

  public static Question mockQuestion() {
    return new Question("Some", List.of("One", "Two"), AnswerType.Single, 1,
        new HashSet<>(List.of(1, 2)));
  }

}
