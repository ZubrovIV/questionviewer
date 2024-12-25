package org.lessons.domain;

import static org.lessons.util.CommonUtils.iffAnyNull;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.lessons.domain.enums.AnswerType;

public class Question {

  private final String questionText;
  private final List<String> answers;
  private final AnswerType answerType;
  private final Integer number;
  private final Set<Integer> correctAnswers;
  private Set<Integer> studentsAnswers;


  public Question(String questionText, List<String> answers, AnswerType answerType, Integer number,
      Set<Integer> correctAnswers
  ) {
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

  public Set<Integer> getCorrectAnswers() {
    return correctAnswers;
  }

  public boolean isMultipleChoice() {
    return Objects.equals(answerType, AnswerType.Multiple);
  }

  public boolean studentsAnswersIsCorrect() {
    if (iffAnyNull(correctAnswers, studentsAnswers)) {
      return false;
    }
    return Objects.equals(studentsAnswers, correctAnswers);
  }

  public void setStudentsAnswers(Set<Integer> studentsAnswers) {
    this.studentsAnswers = studentsAnswers;
  }
}
