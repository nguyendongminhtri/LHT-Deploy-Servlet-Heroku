package com.example.demo12.config;

import com.mysql.cj.ServerVersion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMYSQL {
    private static Connection connection;

    public ConnectMYSQL() {
    }

    public static final String URL = "jdbc:mysql://b8286d93d9c07b:f1a26a21@eu-cdbr-west-01.cleardb.com/heroku_f57f0d0bc085c94?reconnect=true";
    //    public static final String URL = "mysql://b7132afa053dbf:fb387bec@eu-cdbr-west-01.cleardb.com/heroku_2302b9c80aec960?reconnect=true";
    public static final String USER = "b8286d93d9c07b";
    public static final String PASSWORD = "f1a26a21";

    public static Connection getConnect(){
//        if (connection==null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(
                        URL,
                        USER,
                        PASSWORD
                );
                System.out.println("ket noi thanh cong");
            } catch (ClassNotFoundException | SQLException e) {
                System.out.println("ket noi khong thanh cong");
                e.printStackTrace();
            }
//        }

        return  connection;
    }
}
