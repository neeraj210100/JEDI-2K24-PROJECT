package com.flipfit.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    private static Connection conn = null;

    public static Connection getConnection() {
        if(conn == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFitSchema", "root", "12345678");
                return con;
            } catch (Exception e) {
                System.out.println(e);
                return null;
            }
        }return conn;

        }
    }

