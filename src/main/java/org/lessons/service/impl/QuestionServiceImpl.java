package org.lessons.service.impl;

import java.util.List;
import java.util.Objects;
import org.lessons.dao.CsvResourceReader;
import org.lessons.domain.Question;
import org.lessons.service.QuestionParser;
import org.lessons.service.QuestionService;

public class QuestionServiceImpl implements QuestionService {

  private final CsvResourceReader resourceReader;
  private final QuestionParser parser;
  private final String resourcePath;

  public QuestionServiceImpl(CsvResourceReader resourceReader, QuestionParser parser,
      String resourcePath) {
    this.resourceReader = resourceReader;
    this.parser = parser;
    this.resourcePath = resourcePath;
  }


  @Override
  public void getQuestion() {
    List<Question> questions = parser.parse(resourceReader.readCsv(resourcePath));
    if (Objects.isNull(questions) || questions.isEmpty()) {
      System.out.println("No questions found");
      return;
    }
    for (int i = 0; i < questions.size(); i++) {
      Question question = questions.get(i);
      String questionText = "Question " + i + " :" + question.getQuestionText();
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
  }
}
