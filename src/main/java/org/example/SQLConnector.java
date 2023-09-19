package org.example;

import  java.sql.Connection;
import  java.sql.Statement;
import  java.sql.ResultSet;
import  java.sql.DriverManager;
import  java.sql.SQLException;
public class  SQLConnector {
    public static void  main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        //Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
        String dbUrl = "jdbc:mysql://localhost:3306/test";

        //Database Username
        String username = "root";

        //Database Password
        String password = "";

        //Query to Execute
        String query = "ALTER TABLE emp ADD salary int(5);";

        //Load mysql jdbc driver
        Class.forName("com.mysql.jdbc.Driver").newInstance();

        //Create Connection to DB
        Connection con = DriverManager.getConnection(dbUrl,username,password);

        //Create Statement Object
        Statement stmt = con.createStatement();
        stmt.executeQuery(query);
        // Execute the SQL Query. Store results in ResultSet
        ResultSet rs= stmt.executeQuery(query);

        // While Loop to iterate through all data and print results
        while (rs.next()){
            String id = rs.getString(1);

            String address = rs.getString(4);
            String name = rs.getString(2);
            System.out.println(id+"  "+address+"  "+name);
        }
        // closing DB Connection
        con.close();
    }
}