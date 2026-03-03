import java.util.*;
interface IEmployeeStatistics {
    void displayEmployeeStatistics();
}
class Employee implements IEmployeeStatistics {
    private String name;
    private String id;
    private String department;
    private double salary;
    private int experience;
    Employee(String a, String b, String c, double d, int e) {
        this.name = a;
        this.id = b;
        this.department = c;
        this.salary = d;
        this.experience = e;
    }

    public void displayEmployeeStatistics() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Department: " + department);
        System.out.println("Salary: Rs." + salary);
        System.out.println("Years of Experience: " + experience);
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        IEmployeeStatistics emp = null;
        while (true) {
            System.out.println("\n----- Employee Management System -----");
            System.out.println("1. Register Employee");
            System.out.println("2. Display Employee Statistics");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();
            s.nextLine(); 
            switch (choice) {
                case 1:
                    System.out.print("Enter employee name: ");
                    String a = s.nextLine();
                    System.out.print("Enter employee ID: ");
                    String b = s.nextLine();
                    System.out.print("Enter department: ");
                    String c = s.nextLine();
                    System.out.print("Enter salary: ");
                    double d = s.nextDouble();
                    System.out.print("Enter years of experience: ");
                    int e = s.nextInt();
                    emp = new Employee(a, b, c, d, e);
                    System.out.println("Employee registered successfully!");
                    break;
                case 2:
                    if (emp != null) {
                        emp.displayEmployeeStatistics();
                    } else {
                        System.out.println("No employee registered yet.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting System. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
