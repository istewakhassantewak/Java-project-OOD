package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AttendanceManager {
    private List<String> attendanceRecords = new ArrayList<>();

    public void addAttendance(Scanner scanner) {
        System.out.print("Enter attendance details: ");
        String attendance = scanner.nextLine();
        attendanceRecords.add(attendance);
        System.out.println("Attendance added.");
    }

    public void listAttendance() {
        System.out.println("Attendance Records:");
        for (String record : attendanceRecords) {
            System.out.println(record);
        }
    }

    public void updateAttendance(Scanner scanner) {
        System.out.print("Enter attendance details to update: ");
        String oldRecord = scanner.nextLine();
        System.out.print("Enter new attendance details: ");
        String newRecord = scanner.nextLine();
        int index = attendanceRecords.indexOf(oldRecord);
        if (index != -1) {
            attendanceRecords.set(index, newRecord);
            System.out.println("Attendance updated.");
        } else {
            System.out.println("Attendance not found.");
        }
    }

    public void deleteAttendance(Scanner scanner) {
        System.out.print("Enter attendance details to delete: ");
        String record = scanner.nextLine();
        if (attendanceRecords.remove(record)) {
            System.out.println("Attendance deleted.");
        } else {
            System.out.println("Attendance not found.");
        }
    }
}