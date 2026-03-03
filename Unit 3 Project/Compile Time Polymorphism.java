import java.io.*;
import java.util.*;

class Vehicle {
    String bike;
    String car;
    long engineCC;
    long seats;

    void displayVehicleDetails(String bike, String type) {
        String[] arr1 = bike.split(" ");
        String a = arr1[arr1.length - 1];

        System.out.println("Vehicle details of the selection:");
        System.out.println("Model: " + a);
        System.out.println("Type: " + type);
    }

    void displayVehicleDetails(long engineCC, long seats) {
        System.out.println("Technical details of the selection:");
        System.out.println("Engine Capacity: " + engineCC + "cc");
        System.out.println("Seating Capacity: " + seats);
        if (engineCC >= 1000) System.out.println("It is a Heavy Vehicle.");
        else if (engineCC >= 150) System.out.println("It is a Performance Vehicle.");
    }
}
public class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Vehicle v = new Vehicle();
        System.out.println("Menu");
        System.out.println("1. Basic details of the vehicle");
        System.out.println("2. Technical details of the vehicle");
        
        int n = s.nextInt();
        s.nextLine(); 

        if (n == 1) {
            System.out.println("Enter the vehicle name: ");
            v.bike = s.nextLine();
            System.out.println("Enter the vehicle type (Bike/Car): ");
            v.car = s.nextLine();
            v.displayVehicleDetails(v.bike, v.car);
        } else if (n == 2) {
            System.out.println("Enter the engine CC: ");
            v.engineCC = s.nextLong();
            System.out.println("Enter the number of seats: ");
            v.seats = s.nextLong();
            v.displayVehicleDetails(v.engineCC, v.seats);
        } else {
            System.out.println("Invalid Input");
        }

    }
}
