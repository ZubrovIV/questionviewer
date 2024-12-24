package org.lessons.dao.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("Чтение файла")
class CsvResourceReaderImplTest {
  private CsvResourceReaderImpl csvResourceReader;

  @BeforeEach
  void setUp() {
    csvResourceReader = spy(CsvResourceReaderImpl.class);
  }

  @DisplayName("Успешно читаем файл")
  @Test
  void readCsv() {
    String fileName = "test.csv";
    assertNotNull(csvResourceReader.readCsv(fileName));
  }

  @DisplayName("Файл не прочитан")
  @Test
  void readCsv_error() {
    String fileName = "test21.csv";
    assertNull(csvResourceReader.readCsv(fileName));
  }
}