package org.example.dao;

import org.example.model.Student;
import java.util.List;

public interface StudentDAO {

    // Add new student
    int addStudent(Student s) throws Exception;

    // Update existing student
    boolean updateStudent(Student s) throws Exception;

    // Read - Get all students
    List<Student> getAllStudents() throws Exception;

}

