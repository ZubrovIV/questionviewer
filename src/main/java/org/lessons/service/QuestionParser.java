package org.lessons.service;

import java.io.InputStream;
import java.util.List;
import org.lessons.domain.Question;

public interface QuestionParser {

  List<Question> parse(InputStream file);
}
