package com.bank;

import com.db.Database;

import java.sql.SQLException;
import java.util.Scanner;
public class Admin {
    String name, userName, password, bankName;

    public Admin() throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Name: ");
        name = sc.nextLine();
        System.out.println("Enter Username: ");
        userName = sc.nextLine();
        System.out.println("Enter Password: ");
        password = sc.nextLine();
        System.out.println("Enter Bank Name: ");
        bankName = sc.nextLine();

        Database db = new Database("bankingsystem","root","");
        db.addAdmin(name, userName, password, bankName);
    }


    public void displayAdmin(){
        System.out.println("Name: " + name);
        System.out.println("User Name: " + userName);
        System.out.println("Password: " + password);
        System.out.println("Bank Name: " + bankName);
    }
}
