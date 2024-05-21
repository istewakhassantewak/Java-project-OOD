package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssignmentManager {
    private List<String> assignments = new ArrayList<>();

    public void addAssignment(Scanner scanner) {
        System.out.print("Enter assignment details: ");
        String assignment = scanner.nextLine();
        assignments.add(assignment);
        System.out.println("Assignment added.");
    }

    public void listAssignments() {
        System.out.println("Assignments:");
        for (String assignment : assignments) {
            System.out.println(assignment);
        }
    }

    public void updateAssignment(Scanner scanner) {
        System.out.print("Enter assignment details to update: ");
        String oldAssignment = scanner.nextLine();
        System.out.print("Enter new assignment details: ");
        String newAssignment = scanner.nextLine();
        int index = assignments.indexOf(oldAssignment);
        if (index != -1) {
            assignments.set(index, newAssignment);
            System.out.println("Assignment updated.");
        } else {
            System.out.println("Assignment not found.");
        }
    }

    public void deleteAssignment(Scanner scanner) {
        System.out.print("Enter assignment details to delete: ");
        String assignment = scanner.nextLine();
        if (assignments.remove(assignment)) {
            System.out.println("Assignment deleted.");
        } else {
            System.out.println("Assignment not found.");
        }
    }
}
