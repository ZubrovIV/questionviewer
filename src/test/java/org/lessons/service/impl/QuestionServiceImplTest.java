package org.lessons.service.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lessons.dao.CsvResourceReader;
import org.lessons.mock.QuestionMock;
import org.lessons.service.QuestionParser;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

@ExtendWith(MockitoExtension.class)
class QuestionServiceImplTest {

  @Mock
  private CsvResourceReader resourceReader;
  @Mock
  private QuestionParser parser;
  @InjectMocks
  private QuestionServiceImpl questionService;


  @BeforeEach
  void setUp() {
    ReflectionTestUtils.setField(questionService, "resourcePath", "test.csv");
  }

  @Test
  void getQuestion() {
    String csvContent = "mocked CSV content";
    InputStream csvStream = new ByteArrayInputStream(csvContent.getBytes());
    String resourcePath = "test.csv";

    when(resourceReader.readCsv(resourcePath)).thenReturn(csvStream);
    when(parser.parse(csvStream)).thenReturn(List.of(QuestionMock.mockQuestion()));

    questionService.printQuestions();

    verify(parser, times(1)).parse(any());
  }
}