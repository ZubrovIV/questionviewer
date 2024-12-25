package org.lessons.service;

import org.lessons.domain.Question;

public interface QuestionService {

  void printQuestions();

  Question getAnswerForQuestion(Question question);

}
