package org.lessons.dao.impl;

import java.io.InputStream;
import org.lessons.dao.CsvResourceReader;

public class CsvResourceReaderImpl implements CsvResourceReader {

  @Override
  public InputStream readCsv(String path) {
    return getClass().getClassLoader().getResourceAsStream(path);
  }
}
