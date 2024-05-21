package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuesManager {
    private Map<String, Double> dues = new HashMap<>();

    public void addDue(Scanner scanner) {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter due amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        dues.put(studentName, amount);
        System.out.println("Due added.");
    }

    public void listDues() {
        System.out.println("Dues:");
        for (Map.Entry<String, Double> entry : dues.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    public void updateDue(Scanner scanner) {
        System.out.print("Enter student name to update due: ");
        String studentName = scanner.nextLine();
        if (dues.containsKey(studentName)) {
            System.out.print("Enter new due amount: ");
            double amount = Double.parseDouble(scanner.nextLine());
            dues.put(studentName, amount);
            System.out.println("Due updated.");
        } else {
            System.out.println("Due not found for the student.");
        }
    }

    public void deleteDue(Scanner scanner) {
        System.out.print("Enter student name to delete due: ");
        String studentName = scanner.nextLine();
        if (dues.containsKey(studentName)) {
            dues.remove(studentName);
            System.out.println("Due deleted.");
        } else {
            System.out.println("Due not found for the student.");
        }
    }
}
