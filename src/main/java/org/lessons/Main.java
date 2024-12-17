package org.lessons;

import org.lessons.config.ServiceConfig;
import org.lessons.service.TestingService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Main {

  public static void main(String[] args) {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
        ServiceConfig.class);
    context.getBean(TestingService.class).testingStudent();

  }
}