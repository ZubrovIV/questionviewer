package org.lessons.domain;

import java.util.List;
import java.util.Objects;
import org.lessons.domain.enums.AnswerType;

public class Question {

  private String questionText;
  private List<String> answers;
  private AnswerType answerType;


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

  public void setQuestionText(String questionText) {
    this.questionText = questionText;
  }

  public void setAnswers(List<String> answers) {
    this.answers = answers;
  }

  public void setAnswerType(AnswerType answerType) {
    this.answerType = answerType;
  }
}
