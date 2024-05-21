package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransactionManager {
    private List<String> transactions = new ArrayList<>();

    public void addTransaction(Scanner scanner) {
        System.out.print("Enter transaction details: ");
        String transaction = scanner.nextLine();
        transactions.add(transaction);
        System.out.println("Transaction added.");
    }

    public void listTransactions() {
        System.out.println("Transactions:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

    public void updateTransaction(Scanner scanner) {
        System.out.print("Enter transaction details to update: ");
        String oldTransaction = scanner.nextLine();
        System.out.print("Enter new transaction details: ");
        String newTransaction = scanner.nextLine();
        int index = transactions.indexOf(oldTransaction);
        if (index != -1) {
            transactions.set(index, newTransaction);
            System.out.println("Transaction updated.");
        } else {
            System.out.println("Transaction not found.");
        }
    }

    public void deleteTransaction(Scanner scanner) {
        System.out.print("Enter transaction details to delete: ");
        String transaction = scanner.nextLine();
        if (transactions.remove(transaction)) {
            System.out.println("Transaction deleted.");
        } else {
            System.out.println("Transaction not found.");
        }
    }
}