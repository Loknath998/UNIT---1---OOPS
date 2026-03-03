import java.io.*;
import java.util.*;
interface Student {
    void displayStudentDetails(String name, int id);
}
interface Employee {
    void displayEmployeeDetails(String dept, double salary);
}
class ResearchAssistant implements Student, Employee {
    String name;
    int id;
    String dept;
    double salary;
    String project;
    ResearchAssistant(String name, int id, String dept, double salary, String project) {
        this.name = name;
        this.id = id;
        this.dept = dept;
        this.salary = salary;
        this.project = project;
    }
    public void displayStudentDetails(String name, int id) {
        System.out.println("\n--- Academic Record ---");
        System.out.println("Student Name: " + name);
        System.out.println("Enrollment ID: " + id);
    }
    public void displayEmployeeDetails(String dept, double salary) {
        System.out.println("\n--- Employment Record ---");
        System.out.println("Department: " + dept);
        System.out.println("Monthly Stipend: $" + salary);
    }
    void displayProject() {
        System.out.println("Current Research Project: " + project);
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Research Assistant Name:");
        String name = s.nextLine();
        System.out.println("Enter ID:");
        int id = s.nextInt();
        s.nextLine(); 
        System.out.println("Enter Department:");
        String dept = s.nextLine();
        System.out.println("Enter Salary:");
        double salary = s.nextDouble();
        s.nextLine(); 
        System.out.println("Enter Research Project Topic:");
        String project = s.nextLine();
        ResearchAssistant ra = new ResearchAssistant(name, id, dept, salary, project);
        ra.displayStudentDetails(name, id);
        ra.displayEmployeeDetails(dept, salary);
        ra.displayProject();
        s.close();
    }
}
