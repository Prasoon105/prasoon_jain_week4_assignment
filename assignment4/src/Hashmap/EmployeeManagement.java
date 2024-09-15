package Hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeManagement {
	int id;
    private HashMap<Integer, Employee> employeeMap = new HashMap<>();

    public void addEmployee(int id, String name, String department, double salary) {
        Employee employee = new Employee(name, department, salary);
        employeeMap.put(id, employee);
        System.out.println("Employee added successfully.");
    }

    public void getEmployee(int id) {
        Employee employee = employeeMap.get(id);
        if (employee != null) {
            System.out.println("Employee Details (ID: " + id + "):");
            employee.displayEmployee();
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public void displayAllEmployees() {
        if (employeeMap.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("All Employees:");
            for (Map.Entry<Integer, Employee> entry : employeeMap.entrySet()) {
                System.out.println("Employee ID: " + entry.getKey());
                entry.getValue().displayEmployee();
                System.out.println();
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
        EmployeeManagement em = new EmployeeManagement();
        boolean continueOperations = true;

        while (continueOperations) {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Get Employee by ID");
            System.out.println("3. Display All Employees");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    em.addEmployee(id, name, department, salary);
                    break;
                case 2:
                    System.out.print("Enter Employee ID to retrieve: ");
                    int retrieveId = scanner.nextInt();
                    em.getEmployee(retrieveId);
                    break;
                case 3:
                    em.displayAllEmployees();
                    break;
                case 4:
                    continueOperations = false;
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

            if (choice != 4) {
                continueOperations = em.performAnotherOperation(scanner);
            }
        }

    }
}