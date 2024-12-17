package org.lessons.service;

import org.lessons.domain.Answers;
import org.lessons.domain.Question;

public interface AnswerService {

  boolean validateAnswers(Answers answers, Question question);

}
