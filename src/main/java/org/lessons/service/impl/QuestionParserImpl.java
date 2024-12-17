package org.lessons.service.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.lessons.domain.Question;
import org.lessons.domain.enums.AnswerType;
import org.lessons.service.QuestionParser;

public class QuestionParserImpl implements QuestionParser {

  @Override
  public List<Question> parse(InputStream file) {
    List<Question> questions = new ArrayList<>();
    Integer numberOfQuestions = 1;
    try (BufferedReader br = new BufferedReader(new InputStreamReader(file))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] part = line.split(";");
        String questionText = part[0];
        List<String> answers = Arrays.asList(part[1].split(","));
        AnswerType answerType = AnswerType.getType(part[2]);
        List<Integer> correctAnswers = Arrays.stream(part[3].split(","))
            .map(Integer::parseInt)
            .toList();
        questions.add(
            new Question(questionText, answers, answerType, numberOfQuestions, correctAnswers));
        numberOfQuestions++;
      }
    } catch (Exception e) {
      throw new RuntimeException("Failed parse questions", e);
    }
    return questions;
  }
}
