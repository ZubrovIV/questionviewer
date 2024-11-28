package org.lessons.dao;

import java.io.InputStream;

public interface CsvResourceReader {

  InputStream readCsv(String path);
}
