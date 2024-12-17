package org.lessons.service.impl;

import java.util.Scanner;
import org.lessons.domain.Student;
import org.lessons.service.StudentRegistrationService;

public class StudentRegistrationServiceImpl implements StudentRegistrationService {

  private final Scanner scanner = new Scanner(System.in);

  @Override
  public Student registerStudent() {
    System.out.println("Enter your name: ");
    String firstName = scanner.nextLine();
    System.out.println("Enter your last name: ");
    String lastName = scanner.nextLine();
    return new Student(firstName, lastName);
  }
}
