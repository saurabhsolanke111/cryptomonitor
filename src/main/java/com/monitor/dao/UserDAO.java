package com.monitor.dao;

import com.monitor.controller.UserController;
import com.monitor.entities.User;
import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {

    Connection connection = new H2Connection().getConnection();

    public User getUser(int id){
        String qry = "SELECT name, email, min_alert_val, max_alert_val FROM user_d where id = "+id;
        JSONObject ans = new JSONObject();
        JSONArray data = new JSONArray();
        User user = new User();
        int count = 0;
        try(Statement stmt = connection.createStatement()){
            ResultSet resultSet = stmt.executeQuery(qry);
            if (resultSet.next()) {
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setMaxAlertVal(resultSet.getDouble("max_alert_val"));
                user.setMinAlertVal(resultSet.getDouble("min_alert_val"));
                return user;
            }
            ans.append("data", data);
            ans.append("count", count);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return user;
    }

    public User updateUser(double mxval, double minVal){
        String qry = "UPDATE user_d SET max_alert_val = ? , min_alert_val = ? where id = 1";
        User user = new User();
        try(PreparedStatement preparedStatement = connection.prepareStatement(qry)){
                preparedStatement.setDouble(1, mxval);
                preparedStatement.setDouble(2, minVal);
                preparedStatement.executeUpdate();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return user;
    }
}
