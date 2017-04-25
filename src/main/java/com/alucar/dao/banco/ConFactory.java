package com.alucar.dao.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConFactory {
    
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/alucar?autoReconnect=true&useSSL=false", "root", "teste123");
    }
}