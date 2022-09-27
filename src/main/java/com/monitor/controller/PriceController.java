package com.monitor.controller;

import com.monitor.service.PriceService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class PriceController {

    @GetMapping("/api/prices/btc")
    public String getRecords(@RequestParam int limit,
                                 @RequestParam int offset, @RequestParam String date){
        JSONObject ans = new PriceService().getPricesByDate(date, limit, offset);
        ans.append("url", "http://localhost:8084/api/prices/btc?date="+date+"&offset="+offset+"&limit="+limit);
        int count = ans.isNull("count") ? 0 :(Integer) ((JSONArray) ans.get("count")).get(0);
        ans.append("next", "http://localhost:8084/api/prices/btc?date="+date+"&offset="+(offset+count)+"&limit="+limit);
        return ans.toString();
    }

}
