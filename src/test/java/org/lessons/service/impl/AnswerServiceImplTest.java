package org.lessons.service.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lessons.domain.Answers;
import org.lessons.mock.AnswersMock;
import org.lessons.mock.QuestionMock;
import org.lessons.service.AnswerService;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@DisplayName("Проверка правильности ответа")
@ExtendWith(MockitoExtension.class)
class AnswerServiceImplTest {

  @InjectMocks
  private AnswerServiceImpl answerService;


  @Test
  @DisplayName("Передан null")
  void validateAnswers_any_null() {
    assertFalse(answerService.validateAnswers(null, QuestionMock.mockQuestion()));
    assertFalse(answerService.validateAnswers(AnswersMock.getAnswers(), null));
  }

  @Test
  @DisplayName("Корректный ответ, возвращаем true")
  void correct_answers_test() {
    assertTrue(
        answerService.validateAnswers(AnswersMock.getAnswers(), QuestionMock.mockQuestion()));
  }

  @Test
  @DisplayName("Не корректный ответ, возвращаем false")
  void not_correct_answers_test() {
    Answers answers = new Answers(List.of(3));
    assertFalse(answerService.validateAnswers(answers, QuestionMock.mockQuestion()));
  }

  @Test
  @DisplayName("Нет ответов, null в классе Answers")
  void answers_null() {
    Answers answers = new Answers(null);
    assertFalse(answerService.validateAnswers(answers, QuestionMock.mockQuestion()));
  }
}