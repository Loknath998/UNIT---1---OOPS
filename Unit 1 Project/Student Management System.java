import java.io.*;
import java.util.*;

class Student{
    String name;
    int regNo;
    int age;
    String dept;
    int phone;
    String email;

    Student(String a,int b,int c,String d,int e,String f){
        this.name = a;
        this.regNo = b;
        this.age = c;
        this.dept = d;
        this.phone = e;
        this.email = f;
    }
    void display(){
        System.out.println("Name "+name);
        System.out.println("Register No.: "+regNo);
        System.out.println("Age: "+age);
        System.out.println("Department: "+dept);
        System.out.println("Phone No.: "+phone);
        System.out.println("Email Id :"+email);
        
    }
}

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of Students");
        int n = sc.nextInt();
        sc.nextLine();
        Student s[] = new Student[n];
        for(int i = 0;i<n;i++){
            System.out.println("Enter the details of Student "+(i+1));
            String input = sc.nextLine();
            String arr[] = input.split(",");
            String a = arr[0];
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);
            String d = arr[3];
            int e = Integer.parseInt(arr[4]);
            String f = arr[5];
            s[i] = new Student(a,b,c,d,e,f);
            
        }
        System.out.println("Student Details");
        for(int i = 0;i<n;i++){
            s[i].display();
        }
    }
}