package com.bank;

import com.db.Database;

import java.util.Scanner;
public class Customer {
    String customerName, email, address;
    long contactNo;

    public Customer(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Customer Name: ");
        customerName = sc.nextLine();
        System.out.println("Enter Email: ");
        email = sc.nextLine();
        System.out.println("Enter Address: ");
        address = sc.nextLine();
        System.out.println("Enter Contact No: ");
        contactNo = sc.nextLong();

        Database db = new Database("bankingsystem","root","");
        db.addNewCustomer(customerName,email,address,contactNo);

    }

    public void displayCustomer(){
        System.out.println("Customer Name: " + customerName);
        System.out.println("Email: " + email);
        System.out.println("Address: " + address);
        System.out.println("Contact Number: " + contactNo);
    }

}
