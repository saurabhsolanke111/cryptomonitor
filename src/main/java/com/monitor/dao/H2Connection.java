package com.monitor.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class H2Connection {
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";
    static final String USER = "sa";
    static final String PASS = "";

    public Connection getConnection() {
        try{
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
