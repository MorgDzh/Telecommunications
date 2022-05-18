package com.kursovaya.database;

import java.sql.*;

public class Database {

    private static final String URL = "jdbc:mysql://localhost:3306/telecom";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "547523.Kg";

   private static Connection connection(){
       Connection conn;
       try {
           Class.forName("com.mysql.cj.jdbc.Driver");
           conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
           return conn;
       } catch (ClassNotFoundException | SQLException e) {
           throw new RuntimeException(e);
       }
   }

   public Connection getConnection(){
       return connection();
   }

}
