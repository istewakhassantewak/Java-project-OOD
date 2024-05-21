package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FeesManager {
    private Map<String, Double> fees = new HashMap<>();

    public void addFee(Scanner scanner) {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter fee amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        fees.put(studentName, amount);
        System.out.println("Fee added.");
    }

    public void listFees() {
        System.out.println("Fees:");
        for (Map.Entry<String, Double> entry : fees.entrySet()) {
            System.out.println(entry.getKey() + ": $" + entry.getValue());
        }
    }

    public void updateFee(Scanner scanner) {
        System.out.print("Enter student name to update fee: ");
        String studentName = scanner.nextLine();
        if (fees.containsKey(studentName)) {
            System.out.print("Enter new fee amount: ");
            double amount = Double.parseDouble(scanner.nextLine());
            fees.put(studentName, amount);
            System.out.println("Fee updated.");
        } else {
            System.out.println("Fee not found for the student.");
        }
    }

    public void deleteFee(Scanner scanner) {
        System.out.print("Enter student name to delete fee: ");
        String studentName = scanner.nextLine();
        if (fees.containsKey(studentName)) {
            fees.remove(studentName);
            System.out.println("Fee deleted.");
        } else {
            System.out.println("Fee not found for the student.");
        }
    }
}
