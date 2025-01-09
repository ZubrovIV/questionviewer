package org.lessons;

import org.lessons.service.TestingService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(scanBasePackages = "org.lessons")
public class Main {


  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(Main.class, args);

    TestingService testingService = context.getBean(TestingService.class);
    testingService.testingStudent();
  }
}