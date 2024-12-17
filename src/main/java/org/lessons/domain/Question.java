package org.lessons.domain;

import java.util.List;
import java.util.Objects;
import org.lessons.domain.enums.AnswerType;

public class Question {

  private final String questionText;
  private final List<String> answers;
  private final AnswerType answerType;
  private final Integer number;
  private final List<Integer> correctAnswers;


  public Question(String questionText, List<String> answers, AnswerType answerType, Integer number,
      List<Integer> correctAnswers) {
    this.questionText = questionText;
    this.answers = answers;
    this.answerType = answerType;
    this.number = number;
    this.correctAnswers = correctAnswers;
  }

  public String getQuestionText() {
    return questionText;
  }

  public List<String> getAnswers() {
    return answers;
  }

  public Integer getNumber() {
    return number;
  }

  public List<Integer> getCorrectAnswers() {
    return correctAnswers;
  }

  public boolean isMultipleChoice() {
    return Objects.equals(answerType, AnswerType.Multiple);
  }
}
