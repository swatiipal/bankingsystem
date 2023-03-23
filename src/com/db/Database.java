package com.db;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Database {
    String dbUrl="jdbc:mysql://localhost:3306/";
    Connection con;
    public Database(String dbName,String userName, String password){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(dbUrl+dbName,userName,password);

            System.out.println("Connection Established..");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

    public void addNewCustomer(String customerName, String email, String address, long contactNo){
        String sql = "INSERT INTO customer (customer_name,email,address,contact_no) VALUES ("+"'"+customerName+"'"+","+"'"+email+"'"+","+"'"+address+"'"+","+contactNo+")";
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Customer added successfully");
        }catch(Exception e){
            System.out.println("Error occurred while Executing sql statement:"+e);
        }

    }

    public void addAdmin(String name, String userName, String password, String bankName) throws SQLException {
        try (Statement stmt = con.createStatement()) {
            String fetchBankIdQuery = "SELECT id from admin where bank_name="+"'"+bankName.toLowerCase()+"'"+" limit 1";
            ResultSet result = stmt.executeQuery(fetchBankIdQuery);
            if(result.next()){
                    String adminQuery = "INSERT INTO admin (name,username,password,bank_name,bank_id) VALUES (" + "'" + name + "'" + "," + "'" + userName + "'" + "," + "'" + password + "'" + "," + "'" + bankName.toLowerCase() + "'" +","+ Integer.parseInt(result.getString("id"))+ ")";
                    stmt.executeUpdate(adminQuery);
                    System.out.println("Admin added Successfully..");
            }else{
                String newAdminQuery = "INSERT INTO admin (name,username,password,bank_name) VALUES (" + "'" + name + "'" + "," + "'" + userName + "'" + "," + "'" + password + "'" + "," + "'" + bankName.toLowerCase() + "'" +")";
                stmt.executeUpdate(newAdminQuery);
                System.out.println("Admin added Successfully..");
            }
        }
        catch(Exception e){
            System.out.println("Error occurred while executing admin query: " + e);
        }
    }

    }
