package com.monitor.dao;

import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class PriceDAO {

    Connection connection = new H2Connection().getConnection();

    public boolean insertPriceD(Double value){
        String qry = "insert into price_d(coin, curr_val, curr_time) values('btc', "+value+", CURRENT_TIMESTAMP);";
        try(PreparedStatement preparedStatement = connection.prepareStatement(qry)){
            return preparedStatement.executeUpdate() > 0;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    public JSONObject getPriceD(String date, int limit, int offset){
        String qry = "SELECT curr_val, curr_time FROM price_d where cast(curr_time as date) = '"+date+"' order by curr_time asc limit "+limit+" offset "+offset;
        JSONObject ans = new JSONObject();
        JSONArray data = new JSONArray();
        int count = 0;
        try(Statement stmt = connection.createStatement()){
            ResultSet resultSet = stmt.executeQuery(qry);
            while (resultSet.next()) {
                JSONObject jo = new JSONObject();
                jo.append("coin", "btc");
                jo.append("price", resultSet.getDouble("curr_val"));
                jo.append("coin", resultSet.getString("curr_time"));
                ++count;
                data.put(jo);
            }
            ans.append("data", data);
            ans.append("count", count);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return ans;
    }

}
