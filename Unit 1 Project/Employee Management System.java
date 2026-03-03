import java.util.*;
class Employee {
    int id;
    String name;
    String department;
    String designation;
    double salary;

    Employee(int id, String name, String department, String designation, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.designation = designation;
        this.salary = salary;
    }
     void display() {
        System.out.println(id + " | " + name + " | " + department +
                           " | " + designation + " | ₹" + salary);
    }
}

public class EmployeeManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> list = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter Designation: ");
                    String desig = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double sal = sc.nextDouble();
                    list.add(new Employee(id, name, dept, desig, sal));
                    System.out.println("Employee added successfully.");
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No employee records found.");
                    } else {
                        for (Employee e : list) {
                            e.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID: ");
                    int searchId = sc.nextInt();
                    boolean found = false;
                    for (Employee e : list) {
                        if (e.id == searchId) {
                            e.display();
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        System.out.println("Employee not found.");
                    break;

                case 4:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }
}
