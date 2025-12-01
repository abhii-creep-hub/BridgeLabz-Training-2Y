package org.example;

import org.example.dao.StudentDAO;
import org.example.dao.impl.StudentDAOImpl;
import org.example.model.Student;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final StudentDAO studentDao = new StudentDAOImpl();

    public static void main(String[] args) {

        System.out.println("=== Student Management System ===");

        while (true) {
            showMenu();
            String choice = sc.nextLine().trim();

            try {
                switch (choice) {
                    case "1": addStudent(); break;
                    case "2": updateStudent(); break;
                    case "3": listStudents(); break;
                    case "0": System.out.println("Exiting..."); return;
                    default: System.out.println("Invalid choice. Try again.");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n1) Add Student | 2) Update Student | 3) View Students | 0) Exit");
        System.out.print("Choose option: ");
    }

    private static void addStudent() throws Exception {
        Student s = new Student();

        System.out.print("Enter Name: ");
        s.setName(sc.nextLine());

        System.out.print("Enter Course: ");
        s.setCourse(sc.nextLine());

        System.out.print("Enter Email: ");
        s.setEmail(sc.nextLine());

        System.out.print("Enter Phone: ");
        s.setPhone(sc.nextLine());

        int id = studentDao.addStudent(s);
        System.out.println("Student added successfully with ID: " + id);
    }

    private static void updateStudent() throws Exception {
        System.out.print("Enter Student ID to update: ");
        int id = Integer.parseInt(sc.nextLine());

        // Since getStudentById was removed, we ask user full updated data manually
        Student s = new Student();
        s.setStudentId(id);

        System.out.print("New Name: ");
        s.setName(sc.nextLine());

        System.out.print("New Course: ");
        s.setCourse(sc.nextLine());

        System.out.print("New Email: ");
        s.setEmail(sc.nextLine());

        System.out.print("New Phone: ");
        s.setPhone(sc.nextLine());

        boolean updated = studentDao.updateStudent(s);

        System.out.println(updated ? "Student Updated Successfully." : "Update Failed.");
    }

    private static void listStudents() throws Exception {
        List<Student> students = studentDao.getAllStudents();

        System.out.println("\n--- Student List ---");
        System.out.println("ID | Name | Course | Email | Phone");
        for (Student s : students) {
            System.out.printf("%d | %s | %s | %s | %s%n",
                    s.getStudentId(), s.getName(), s.getCourse(), s.getEmail(), s.getPhone());
        }
    }
}

