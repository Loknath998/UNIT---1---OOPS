import java.io.*;
import java.util.*;

class HospitalPerson {
    String name;
    int id;
    String gender;

    HospitalPerson(String n, int i, String g) {
        this.name = n;
        this.id = i;
        this.gender = g;
    }

    void displayBasicInfo() {
        System.out.println("\nHospital Record Details:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Gender: " + gender);
    }
}

class Doctor extends HospitalPerson {
    String specialization;

    Doctor(String n, int i, String g, String s) {
        super(n, i, g);
        this.specialization = s;
    }

    void displaySpecialization() {
        System.out.println("Specialization: " + specialization);
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Input Collection
        System.out.println("Enter the Doctor's name:");
        String n = s.nextLine();
        System.out.println("Enter the Staff ID:");
        int i = s.nextInt();
        s.nextLine(); // Buffer clear
        System.out.println("Enter the Gender:");
        String g = s.nextLine();
        System.out.println("Enter the Specialization (e.g., Cardiology):");
        String spec = s.nextLine();

        Doctor d = new Doctor(n, i, g, spec);
        
        d.displayBasicInfo();
        d.displaySpecialization();
        s.close();
    }
}
