package org.lessons.service;

import org.lessons.domain.Answers;
import org.lessons.domain.Question;

public interface QuestionService {

  void printQuestions();

  Answers getAnswerForQuestion(Question question);

}
