package org.lessons.service.dependencies;

import org.lessons.dao.CsvResourceReader;
import org.lessons.service.AnswerService;
import org.lessons.service.QuestionParser;
import org.lessons.service.QuestionService;
import org.lessons.service.StudentRegistrationService;

public record TestingServiceDependencies(StudentRegistrationService studentRegistrationService,
                                         QuestionService questionService,
                                         QuestionParser questionParser,
                                         CsvResourceReader resourceReader,
                                         AnswerService answerService) {

}
