package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GradeManager {
    private Map<String, String> grades = new HashMap<>();

    public void addGrade(Scanner scanner) {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();
        grades.put(studentName, grade);
        System.out.println("Grade added.");
    }

    public void listGrades() {
        System.out.println("Grades:");
        for (Map.Entry<String, String> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public void updateGrade(Scanner scanner) {
        System.out.print("Enter student name to update grade: ");
        String studentName = scanner.nextLine();
        if (grades.containsKey(studentName)) {
            System.out.print("Enter new grade: ");
            String grade = scanner.nextLine();
            grades.put(studentName, grade);
            System.out.println("Grade updated.");
        } else {
            System.out.println("Grade not found for the student.");
        }
    }

    public void deleteGrade(Scanner scanner) {
        System.out.print("Enter student name to delete grade: ");
        String studentName = scanner.nextLine();
        if (grades.containsKey(studentName)) {
            grades.remove(studentName);
            System.out.println("Grade deleted.");
        } else {
            System.out.println("Grade not found for the student.");
        }
    }
}
