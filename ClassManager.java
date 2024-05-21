package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassManager {
    private List<String> classes = new ArrayList<>();

    public void createClass(Scanner scanner) {
        System.out.print("Enter class name: ");
        String className = scanner.nextLine();
        classes.add(className);
        System.out.println("Class created.");
    }

    public void listClasses() {
        System.out.println("Classes:");
        for (String className : classes) {
            System.out.println(className);
        }
    }

    public void updateClass(Scanner scanner) {
        System.out.print("Enter class name to update: ");
        String oldName = scanner.nextLine();
        System.out.print("Enter new class name: ");
        String newName = scanner.nextLine();
        int index = classes.indexOf(oldName);
        if (index != -1) {
            classes.set(index, newName);
            System.out.println("Class updated.");
        } else {
            System.out.println("Class not found.");
        }
    }

    public void deleteClass(Scanner scanner) {
        System.out.print("Enter class name to delete: ");
        String className = scanner.nextLine();
        if (classes.remove(className)) {
            System.out.println("Class deleted.");
        } else {
            System.out.println("Class not found.");
        }
    }
}