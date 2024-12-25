package org.lessons.config;

import java.util.Scanner;
import org.lessons.dao.CsvResourceReader;
import org.lessons.dao.impl.CsvResourceReaderImpl;
import org.lessons.service.QuestionParser;
import org.lessons.service.QuestionService;
import org.lessons.service.StudentRegistrationService;
import org.lessons.service.TestingService;
import org.lessons.service.impl.QuestionParserImpl;
import org.lessons.service.impl.QuestionServiceImpl;
import org.lessons.service.impl.StudentRegistrationServiceImpl;
import org.lessons.service.impl.TestingServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.lessons")
@PropertySource("classpath:application.properties")
public class ServiceConfig {

  @Value("${passing.score}")
  private Integer passingScore;

  @Value("${resource.path}")
  private String resourcePath;

  private final Scanner scanner = new Scanner(System.in);

  @Bean
  public CsvResourceReader csvResourceReader() {
    return new CsvResourceReaderImpl();
  }

  @Bean
  public StudentRegistrationService studentRegistrationService() {
    return new StudentRegistrationServiceImpl(scanner);
  }

  @Bean
  public QuestionParser questionParser() {
    return new QuestionParserImpl();
  }

  @Bean
  public QuestionService questionService() {
    return new QuestionServiceImpl(csvResourceReader(), questionParser(), resourcePath);
  }


  @Bean
  public TestingService testingService() {
    return new TestingServiceImpl(studentRegistrationService(), questionService(), questionParser(),
        csvResourceReader(), passingScore, resourcePath);
  }


}
