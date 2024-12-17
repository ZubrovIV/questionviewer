package org.lessons;

import org.lessons.service.QuestionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
    QuestionService questionService = context.getBean(QuestionService.class);
    questionService.printQuestions();
  }
}