package org.lessons.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lessons.domain.Question;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("Класс для парсинга вопросов из файла")
class QuestionParserImplTest {

  @InjectMocks
  private QuestionParserImpl questionParser;
  private InputStream stream;


  @BeforeEach
  void setUp() {
    String path = "test.csv";
    stream = getClass().getClassLoader().getResourceAsStream(path);
  }

  @Test
  @DisplayName("Успешно распарсили")
  void parse_success() {
    List<Question> questions = questionParser.parse(stream);

    assertNotNull(questions);
    assertEquals(5, questions.size());
    assertTrue(questions.stream().anyMatch(question -> Objects.equals(question.getQuestionText(),
        "What is the purpose of the try-catch block in Java?")));
  }

  @Test
  @DisplayName("Не удалось распарсить")
  void parse_error() {
    assertThrows(RuntimeException.class,
        () -> questionParser.parse(new ByteArrayInputStream("test".getBytes())));
  }
}