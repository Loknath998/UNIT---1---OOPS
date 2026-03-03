import java.util.*;
class Employee {
    private String name;
    private int id;
    private String designation;
    private double salary;
    public void setname(String a) {
        this.name = a;
    }
    public void setid(int b) {
        this.id = b; 
    }
    public void setdesignation(String c) {
        this.designation = c; 
    }
    public void setsalary(double d) {
        this.salary = d; 
    }

    public String getname() { 
        return name; 
    }
    public int getid() { 
        return id; 
    }
    public String getdesignation() { 
        return designation; 
    }
    public double getsalary() {
        return salary; 
    }
    public void addBonus(double bonus) {
        if (bonus <= 0) {
            System.out.println("Invalid Bonus Amount");
        } else {
            salary += bonus;
            System.out.println("Bonus added. Updated Salary: " + salary);
        }
    }
    public void updateSalary(double increment) {
        if (increment <= 0) {
            System.out.println("Invalid Increment");
        } else {
            salary += increment;
            System.out.println("Salary updated successfully.");
        }
    }

    void display() {
        System.out.println("\n--- Employee Details ---");
        System.out.println("Name: " + getname());
        System.out.println("ID: " + getid());
        System.out.println("Designation: " + getdesignation());
        System.out.println("Current Salary: " + getsalary());
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Employee Name:");
        String a = sc.nextLine();
        System.out.println("Enter Employee ID:");
        int b = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Designation:");
        String c = sc.nextLine();
        System.out.println("Enter Initial Salary:");
        double d = sc.nextDouble();
        Employee emp = new Employee();
        emp.setname(a);
        emp.setid(b);
        emp.setdesignation(c);
        emp.setsalary(d);
        emp.display();
        System.out.println("\nEnter bonus to add:");
        double bonus = sc.nextDouble();
        emp.addBonus(bonus);
        System.out.println("Enter basic increment to add:");
        double inc = sc.nextDouble();
        emp.updateSalary(inc);
        emp.display();
    }
}
