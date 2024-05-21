package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TutorManager {
    private List<String> tutors = new ArrayList<>();

    public void addTutor(Scanner scanner) {
        System.out.print("Enter tutor name: ");
        String tutorName = scanner.nextLine();
        tutors.add(tutorName);
        System.out.println("Tutor added.");
    }

    public void listTutors() {
        System.out.println("Tutors:");
        for (String tutor : tutors) {
            System.out.println(tutor);
        }
    }

    public void updateTutor(Scanner scanner) {
        System.out.print("Enter tutor name to update: ");
        String oldName = scanner.nextLine();
        System.out.print("Enter new tutor name: ");
        String newName = scanner.nextLine();
        int index = tutors.indexOf(oldName);
        if (index != -1) {
            tutors.set(index, newName);
            System.out.println("Tutor updated.");
        } else {
            System.out.println("Tutor not found.");
        }
    }

    public void deleteTutor(Scanner scanner) {
        System.out.print("Enter tutor name to delete: ");
        String tutorName = scanner.nextLine();
        if (tutors.remove(tutorName)) {
            System.out.println("Tutor deleted.");
        } else {
            System.out.println("Tutor not found.");
        }
    }
}