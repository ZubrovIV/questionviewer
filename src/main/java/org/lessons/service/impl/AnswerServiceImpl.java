package org.lessons.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import org.lessons.domain.Answers;
import org.lessons.domain.Question;
import org.lessons.service.AnswerService;

public class AnswerServiceImpl implements AnswerService {

  @Override
  public boolean validateAnswers(Answers answers, Question question) {
    if (iffAnyNull(answers, question)) {
      return false;
    }

    List<Integer> userResponses = answers.answers();
    List<Integer> correctAnswers = question.getCorrectAnswers();

    if (iffAnyNull(userResponses, correctAnswers)) {
      return false;
    }
    return Objects.equals(toHashSet(userResponses), toHashSet(correctAnswers));
  }

  private boolean iffAnyNull(Object... objects) {
    return Arrays.stream(objects).anyMatch(Objects::isNull);
  }

  private <T> HashSet<T> toHashSet(List<T> list) {
    return new HashSet<>(list);
  }
}
