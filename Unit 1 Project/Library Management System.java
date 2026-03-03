import java.io.*;
import java.util.*;

class Library {
    String name;
    int bookNo;
    float price;
    String author;
    String borrow;
    String Return;

    Library(String a, int b, float c, String d, String e, String f) {
        this.name = a;
        this.bookNo = b;
        this.price = c;
        this.author = d;
        this.borrow = e;
        this.Return = f;
    }

    void display() {
        System.out.println("Book Name: " + name);
        System.out.println("Book No. : " + bookNo);
        System.out.println("Book Price : " + price);
        System.out.println("Author Name : " + author);
        System.out.println("Date of borrow : " + borrow);
        System.out.println("Date of return : " + Return);
        System.out.println("--------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib[] = new Library[100];
        int count = 0;
        int choice;

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Name: ");
                    String a = sc.nextLine();
                    System.out.print("Enter Book Number: ");
                    int b = sc.nextInt();
                    System.out.print("Enter Price: ");
                    float c = sc.nextFloat();
                    sc.nextLine();
                    System.out.print("Enter Author: ");
                    String d = sc.nextLine();
                    System.out.print("Enter Date of Borrow: ");
                    String e = sc.nextLine();
                    System.out.print("Enter Date of Return: ");
                    String f = sc.nextLine();

                    lib[count] = new Library(a, b, c, d, e, f);
                    count++;
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No records found.");
                    } else {
                        System.out.println("\n--- Registered Book Details ---");
                        for (int i = 0; i < count; i++) {
                            lib[i].display();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting System...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
