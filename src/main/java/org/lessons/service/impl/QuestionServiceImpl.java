package org.lessons.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import org.lessons.dao.CsvResourceReader;
import org.lessons.domain.Answers;
import org.lessons.domain.Question;
import org.lessons.service.QuestionParser;
import org.lessons.service.QuestionService;

public class QuestionServiceImpl implements QuestionService {

  private final CsvResourceReader resourceReader;
  private final QuestionParser parser;
  private final String resourcePath;
  private final Scanner scanner = new Scanner(System.in);

  public QuestionServiceImpl(CsvResourceReader resourceReader, QuestionParser parser,
      String resourcePath) {
    this.resourceReader = resourceReader;
    this.parser = parser;
    this.resourcePath = resourcePath;
  }


  @Override
  public void printQuestions() {
    List<Question> questions = parser.parse(resourceReader.readCsv(resourcePath));
    if (Objects.isNull(questions) || questions.isEmpty()) {
      System.out.println("No questions found");
      return;
    }
    for (Question question : questions) {
      printQuestion(question);
    }
  }

  @Override
  public Answers getAnswerForQuestion(Question question) {
    if (Objects.isNull(question) || Objects.isNull(question.getAnswers())) {
      System.out.println("No question provided or no answers available");
      return null;
    }
    printQuestion(question);
    if (question.isMultipleChoice()) {
      return getAnswerForQuestionWithMultiple(question.getAnswers().size());
    } else {
      return getAnswerForQuestionWithSingle(question.getAnswers().size());
    }
  }

  private void printQuestion(Question question) {
    String questionText = "Question " + question.getNumber() + " :" + question.getQuestionText();
    if (question.isMultipleChoice()) {
      questionText = questionText + " (" + "There may be several possible answers" + ") ";
    }
    System.out.println(questionText);
    if (!question.getAnswers().isEmpty()) {
      for (int j = 0; j < question.getAnswers().size(); j++) {
        System.out.println(j + 1 + ". " + question.getAnswers().get(j));
      }
    } else {
      System.out.println("No answers available");
    }
  }

  private Answers getAnswerForQuestionWithMultiple(Integer answersSize) {
    System.out.println("Enter answer numbers separated by space: ");
    String answerNumbers = scanner.nextLine();
    try {
      List<Integer> answers = Arrays.stream(answerNumbers.trim().split(" "))
          .map(Integer::parseInt)
          .filter(i -> i > 0 && i <= answersSize)
          .toList();
      return new Answers(answers);
    } catch (Exception e) {
      System.out.println("Invalid input");
      return null;
    }
  }

  private Answers getAnswerForQuestionWithSingle(Integer answersSize) {
    System.out.println("Enter answer number: ");
    try {
      int answer = Integer.parseInt(scanner.nextLine());
      if (answer > 0 && answer <= answersSize) {
        return new Answers(List.of(answer));
      } else {
        return null;
      }
    } catch (Exception e) {
      System.out.println("Invalid input");
      return null;
    }
  }
}
