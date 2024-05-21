package com.example;

import java.util.Scanner;

public class CoachingCenterManagement {
    private static final Scanner scanner = new Scanner(System.in);
    private static final UserManager userManager = new UserManager();
    private static final AssignmentManager assignmentManager = new AssignmentManager();
    private static final ClassManager classManager = new ClassManager();
    private static final AttendanceManager attendanceManager = new AttendanceManager();
    private static final DuesManager duesManager = new DuesManager();
    private static final TransactionManager transactionManager = new TransactionManager();
    private static final FeesManager feesManager = new FeesManager();
    private static final GradeManager gradeManager = new GradeManager();
    private static final TutorManager tutorManager = new TutorManager();
    private User currentUser;

    public void start() {
        while (true) {
            System.out.println("\nCoaching Center Management System");
            System.out.println("1. User Signup");
            System.out.println("2. User Login");
            System.out.println("3. Admin Signup");
            System.out.println("4. Admin Login");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    handleUserSignup();
                    break;
                case 2:
                    handleUserLogin();
                    break;
                case 3:
                    handleAdminSignup();
                    break;
                case 4:
                    handleAdminLogin();
                    break;
                case 5:
                    System.out.println("Exiting the system.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleUserSignup() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        if (userManager.registerUser(username, password, email)) {
            System.out.println("User Signup successful.");
        } else {
            System.out.println("Username already exists.");
        }
    }

    private void handleUserLogin() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
    
        if (userManager.authenticateUser(username, password)) {
            System.out.println("User Login successful.");
            currentUser = userManager.getUser(username);
            handleUserOptions();
        } else {
            System.out.println("Invalid username or password.");
        }
    }
    
    private void handleUserOptions() {
        while (true) {
            System.out.println("\nUser Options");
            System.out.println("1. View Assignments");
            System.out.println("2. View Classes");
            System.out.println("3. View Attendance");
            System.out.println("4. View Dues");
            System.out.println("5. View Transactions");
            System.out.println("6. View Fees");
            System.out.println("7. View Grades");
            System.out.println("8. View Tutors");
            System.out.println("9. View Personal Information");
            System.out.println("10. Upgrade Profile");
            System.out.println("11. Logout");
            System.out.print("Choose an option: ");
    
            int choice = Integer.parseInt(scanner.nextLine());
    
            switch (choice) {
                case 1:
                    assignmentManager.listAssignments();
                    break;
                case 2:
                    classManager.listClasses();
                    break;
                case 3:
                    attendanceManager.listAttendance();
                    break;
                case 4:
                    duesManager.listDues();
                    break;
                case 5:
                    transactionManager.listTransactions();
                    break;
                case 6:
                    feesManager.listFees();
                    break;
                case 7:
                    gradeManager.listGrades();
                    break;
                case 8:
                    tutorManager.listTutors();
                    break;
                case 9:
                    viewPersonalInformation();
                    break;
                case 10:
                    upgradeProfile();
                    break;
                case 11:
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
    private void viewPersonalInformation() {
        // Implement logic to display personal information of the current user/student
        System.out.println("Personal Information:");
        System.out.println("Username: " + currentUser.getUsername());
        System.out.println("Email: " + currentUser.getEmail());
        if (currentUser instanceof Student) {
            Student student = (Student) currentUser;
            System.out.println("ID: " + student.getId());
            System.out.println("Name: " + student.getName());
            System.out.println("Class: " + student.getClassName());
            System.out.println("Section: " + student.getSection());
        }
        // Add additional personal information display as needed
    }

    private void upgradeProfile() {
        System.out.print("Enter ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Class: ");
        String className = scanner.nextLine();
        System.out.print("Enter Section: ");
        String section = scanner.nextLine();

        userManager.upgradeProfile(currentUser.getUsername(), id, name, className, section);
    }

    private void handleAdminSignup() {
        System.out.print("Enter admin username: ");
        String adminUsername = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String adminPassword = scanner.nextLine();
        System.out.print("Enter admin email: ");
        String adminEmail = scanner.nextLine();

        if (userManager.registerAdmin(adminUsername, adminPassword, adminEmail)) {
            System.out.println("Admin Signup successful.");
        } else {
            System.out.println("Admin username already exists.");
        }
    }

    private void handleAdminLogin() {
        // Admin login logic
        System.out.print("Enter admin username: ");
        String adminUsername = scanner.nextLine();
        System.out.print("Enter admin password: ");
        String adminPassword = scanner.nextLine();

        if (userManager.authenticateAdmin(adminUsername, adminPassword)) {
            System.out.println("Admin Login successful.");
            currentUser = userManager.getAdmin(adminUsername);
            handleAdminOptions();
        } else {
            System.out.println("Invalid admin username or password.");
        }
    }

    private void handleAdminOptions() {
        while (true) {
            System.out.println("\nAdmin Options");
            System.out.println("1. Add Assignment");
            System.out.println("2. Add Class");
            System.out.println("3. Add Attendance");
            System.out.println("4. Add Dues");
            System.out.println("5. Add Transaction");
            System.out.println("6. Add Fees");
            System.out.println("7. Add Grade");
            System.out.println("8. Add Tutor");
            System.out.println("9. View Student Information");
            System.out.println("10. Logout");
            System.out.print("Choose an option: ");
    
            int choice = Integer.parseInt(scanner.nextLine());
    
            switch (choice) {
                case 1:
                    assignmentManager.addAssignment(scanner);
                    break;
                case 2:
                    classManager.createClass(scanner);
                    break;
                case 3:
                    attendanceManager.addAttendance(scanner);
                    break;
                case 4:
                    duesManager.addDue(scanner);
                    break;
                case 5:
                    transactionManager.addTransaction(scanner);
                    break;
                case 6:
                    feesManager.addFee(scanner);
                    break;
                case 7:
                    gradeManager.addGrade(scanner);
                    break;
                case 8:
                    tutorManager.addTutor(scanner);
                    break;
                case 9:
                    userManager.viewStudentInformation();
                    break;
                case 10:
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
