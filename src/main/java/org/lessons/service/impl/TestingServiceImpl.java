package org.lessons.service.impl;

import java.util.List;
import java.util.Objects;
import org.lessons.dao.CsvResourceReader;
import org.lessons.domain.Question;
import org.lessons.domain.Student;
import org.lessons.service.QuestionParser;
import org.lessons.service.QuestionService;
import org.lessons.service.StudentRegistrationService;
import org.lessons.service.TestingService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TestingServiceImpl implements TestingService {

  private final StudentRegistrationService studentRegistrationService;
  private final QuestionService questionService;
  private final QuestionParser questionParser;
  private final CsvResourceReader resourceReader;

  @Value("${passing.score}")
  private Integer passingScore;
  @Value("${resource.path}")
  private String resourcePath;

  public TestingServiceImpl(StudentRegistrationService studentRegistrationService,
      QuestionService questionService, QuestionParser questionParser,
      CsvResourceReader resourceReader) {
    this.studentRegistrationService = studentRegistrationService;
    this.questionService = questionService;
    this.questionParser = questionParser;
    this.resourceReader = resourceReader;
  }


  @Override
  public void testingStudent() {
    Student student = studentRegistrationService.registerStudent();

    List<Question> questions = questionParser
        .parse(resourceReader.readCsv(resourcePath));
    if (Objects.isNull(questions) || questions.isEmpty()) {
      System.out.println("No questions found");
      return;
    }

    int score = 0;

    for (Question question : questions) {
      Question answerForQuestion = questionService.getAnswerForQuestion(question);
      if (answerForQuestion.studentsAnswersIsCorrect()) {
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
