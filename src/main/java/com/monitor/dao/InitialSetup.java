package com.monitor.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class InitialSetup {
    private Connection connection = new H2Connection().getConnection();

    public void init(){
        createUserTable();
        createCoinTable();
    }

    private void createUserTable(){
        try(Statement stmt = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS user_d " +
                    "(id bigint auto_increment, " +
                    " name VARCHAR(255), " +
                    " min_alert_val INTEGER, " +
                    " max_alert_val INTEGER, " +
                    " email VARCHAR(100))";
            stmt.executeUpdate(sql);
            System.out.println("Created USER table in given database...");
            insertInitUser();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void insertInitUser(){

        String sql = "insert into user_d(name, email, min_alert_val, max_alert_val) values('saurabh', 'saurabhmail@gmail.com', 1000, 2000);";
        try(PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.executeUpdate();
            System.out.println("Created USER abs in database...");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void createCoinTable(){
        try(Statement stmt = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS  price_d " +
                    "(id bigint auto_increment, " +
                    " coin VARCHAR(255), " +
                    " curr_val NUMERIC, " +
                    " curr_time TIMESTAMP)";
            stmt.executeUpdate(sql);
            System.out.println("Created Coin table in given database...");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
