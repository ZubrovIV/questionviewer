package org.lessons.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.lessons.domain.Student;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StudentRegistrationServiceImplTest {

  @InjectMocks
  private StudentRegistrationServiceImpl studentRegistrationService;
  @Mock
  private Scanner scanner;

  @Test
  void registerStudent() {
    when(scanner.nextLine()).thenReturn("John","D");

    Student student = studentRegistrationService.registerStudent();

    assertEquals("John", student.firstName());
    assertEquals("D", student.lastName());
  }
}