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
        String adminquery = "INSERT INTO admin (name,username,password,bank_name) VALUES (" + "'" + name + "'" + "," + "'" + userName + "'" + "," + "'" + password + "'" + "," + "'" + bankName + "'" + ")";
        try (Statement stmt = con.createStatement()) {
            String query = "select * from admin";
            ResultSet result = stmt.executeQuery(query);
            List<AdminsDto> adminDto = (List<AdminsDto>) result;
//            while(result.next()){
//                for (AdminsDto admin : adminDto) {
//                    admin.setId(result.getString("id"));
//                    admin.setName(result.getString("name"));
//                    admin.setUserName(result.getString("username"));
//                    admin.setPassword(result.getString("password"));
//                    admin.setBankName(result.getString("bank_name"));
//                }
//            }
            System.out.println(adminDto);
//            while (rs.next()) {
//                String coffeeName = rs.getString("COF_NAME");
//                int supplierID = rs.getInt("SUP_ID");
//                float price = rs.getFloat("PRICE");
//                int sales = rs.getInt("SALES");
//                int total = rs.getInt("TOTAL");
//                System.out.println(coffeeName + ", " + supplierID + ", " + price +
//                        ", " + sales + ", " + total);
//
//                stmt.executeUpdate(adminquery);
//                System.out.println("Admin added Successfully..");
//            }
        }
        catch(Exception e){
            System.out.println("Error occurred while executing admin query: " + e);
        }
    }

    }
