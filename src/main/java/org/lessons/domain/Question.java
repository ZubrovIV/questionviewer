package org.lessons.domain;

import java.util.List;
import java.util.Objects;
import org.lessons.domain.enums.AnswerType;

public class Question {

  private final String questionText;
  private final List<String> answers;
  private final AnswerType answerType;


  public Question(String questionText, List<String> answers, AnswerType answerType) {
    this.questionText = questionText;
    this.answers = answers;
    this.answerType = answerType;
  }

  public String getQuestionText() {
    return questionText;
  }

  public List<String> getAnswers() {
    return answers;
  }

  public boolean isMultipleChoice() {
    return Objects.equals(answerType, AnswerType.Multiple);
  }
}
