package org.lessons.service.impl;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.lessons.dao.CsvResourceReader;
import org.lessons.service.QuestionParser;
import org.lessons.service.impl.mock.QuestionMock;

class QuestionServiceImplTest {

  private CsvResourceReader resourceReader;
  private QuestionParser parser;
  private QuestionServiceImpl questionService;

  @BeforeEach
  void setUp() {
    resourceReader = mock(CsvResourceReader.class);
    parser = mock(QuestionParser.class);
    questionService = new QuestionServiceImpl(resourceReader,parser,"text.csv");
  }

  @Test
  void getQuestion() {
    String csvContent = "mocked CSV content";
    InputStream csvStream = new ByteArrayInputStream(csvContent.getBytes());
    String resourcePath = "text.csv";

    when(resourceReader.readCsv(resourcePath)).thenReturn(csvStream);
    when(parser.parse(csvStream)).thenReturn(List.of(QuestionMock.mockQuestion()));

    questionService.printQuestions();

    verify(parser,times(1)).parse(csvStream);
  }
}