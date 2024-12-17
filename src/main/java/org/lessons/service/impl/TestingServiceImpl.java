package org.lessons.service.impl;

import java.util.List;
import java.util.Objects;
import org.lessons.domain.Answers;
import org.lessons.domain.Question;
import org.lessons.domain.Student;
import org.lessons.service.TestingService;
import org.lessons.service.dependencies.TestingServiceDependencies;

public class TestingServiceImpl implements TestingService {

  private final TestingServiceDependencies dependencies;

  private final Integer passingScore;
  private final String resourcePath;

  public TestingServiceImpl(TestingServiceDependencies dependencies, Integer passingScore,
      String resourcePath) {
    this.dependencies = dependencies;
    this.passingScore = passingScore;
    this.resourcePath = resourcePath;
  }


  @Override
  public void testingStudent() {
    Student student = dependencies.studentRegistrationService().registerStudent();

    List<Question> questions = dependencies.questionParser()
        .parse(dependencies.resourceReader().readCsv(resourcePath));

    if (Objects.isNull(questions) || questions.isEmpty()) {
      System.out.println("No questions found");
      return;
    }

    int score = 0;

    for (Question question : questions) {
      Answers answerForQuestion = dependencies.questionService().getAnswerForQuestion(question);
      if (dependencies.answerService().validateAnswers(answerForQuestion, question)) {
        score++;
      }
    }

    printResult(score, student);
  }

  private void printResult(int score, Student student) {
    if (score >= passingScore) {
      System.out.printf("Test passed for student %s %s score %d%n", student.firstName(),
          student.lastName(), score);
    } else {
      System.out.printf("Test failed for student %s %s score %d%n", student.firstName(),
          student.lastName(), score);
    }
  }
}
