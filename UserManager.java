package com.example;

import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, User> users = new HashMap<>();
    private Map<String, User> admins = new HashMap<>();

    public boolean registerUser(String username, String password, String email) {
        if (users.containsKey(username)) {
            return false; 
        }
        users.put(username, new Student(username, password, email));
        return true;
    }

    public boolean registerAdmin(String username, String password, String email) {
        if (admins.containsKey(username)) {
            return false; 
        }
        admins.put(username, new User(username, password, email));
        return true;
    }

    public boolean authenticateUser(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public boolean authenticateAdmin(String username, String password) {
        User admin = admins.get(username);
        return admin != null && admin.getPassword().equals(password);
    }

    public User getUser(String username) {
        return users.get(username);
    }

    public User getAdmin(String username) {
        return admins.get(username);
    }

    public void upgradeProfile(String username, String id, String name, String className, String section) {
        User user = users.get(username);
        if (user != null && user instanceof Student) {
            Student student = (Student) user;
            student.setId(id);
            student.setName(name);
            student.setClassName(className);
            student.setSection(section);
            System.out.println("Profile upgraded successfully.");
        } else {
            System.out.println("User not found or is not a student.");
        }
    }

    public void viewStudentInformation() {
        // Retrieve and display information of all students
        System.out.println("\nStudent Information:");
        for (User user : users.values()) {
            if (user instanceof Student) {
                Student student = (Student) user;
                System.out.println("ID: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Class: " + student.getClassName());
                System.out.println("Section: " + student.getSection());
                // Add additional student information as needed
                System.out.println("------------------------");
            }
        }
    }
}
