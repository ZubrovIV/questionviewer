package org.lessons.service.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.lessons.domain.Question;
import org.lessons.domain.enums.AnswerType;
import org.lessons.service.QuestionParser;
import org.springframework.stereotype.Service;

@Service
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
        Set<Integer> correctAnswers = Arrays.stream(part[3].split(","))
            .map(Integer::parseInt)
            .collect(Collectors.toSet());
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
