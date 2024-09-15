package Arraylist;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    
    private ArrayList<Student> s = new ArrayList<>();

    
    public void addStudent(String name, int id) {
        Student student = new Student(name, id);
        s.add(student);
        System.out.println("Student added successfully.");
    }
  
    public void removeStudent(int id) {
        boolean studentFound = false;
        for (Student student : s) {
            if (student.getId() == id) {
                s.remove(student);
                System.out.println("Student removed successfully.");
                studentFound = true;
                break;
            }
        }
        if (!studentFound) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }

    public void displayStudents() {
        if (s.isEmpty()) {
            System.out.println("No students in the list.");
        } else {
            System.out.println("List of students:");
            for (Student student : s) {
                student.displayStudent();
            }
        }
    }

    public boolean performAnotherOperation(Scanner scanner) {
        System.out.print("\nDo you want to perform another operation? (y/n): ");
        String response = scanner.next();
        return response.equalsIgnoreCase("yes");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagement sm = new StudentManagement();
        boolean continueOperations = true;

        while (continueOperations) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display Students");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    sm.addStudent(name, id);
                    break;
                case 2:
                    System.out.print("Enter student ID to remove: ");
                    int removeId = scanner.nextInt();
                    sm.removeStudent(removeId);
                    break;
                case 3:
                    sm.displayStudents();
                    break;
                case 4:
                    continueOperations = false;
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            if (choice != 4) { 
                continueOperations = sm.performAnotherOperation(scanner);
            }
        }

    }
}
