package com.monitor.service;

import com.monitor.dao.PriceDAO;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PriceService {

    public JSONObject getPricesByDate(String date, int limit, int offset){
        return new PriceDAO().getPriceD(date, limit, offset);
    }
}
