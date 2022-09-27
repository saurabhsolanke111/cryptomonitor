package com.monitor.service;

import okhttp3.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;



public class Watcher {
    public static final long PERIOD = 30000;
    private final OkHttpClient client = new OkHttpClient();

    public void launch() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                loadBitcoinPrice(new Callback() {

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String str = response.body().string();
                        parseBitcoinPrice(str);
                    }

                    @Override
                    public void onFailure(Call call, IOException ioe) {
                        System.out.println(" ################### Fail #################### \n");
                    }
                });
            }
        }, 0, PERIOD);
    }

    private void loadBitcoinPrice(Callback callback) {
        String coinGeckoURI = "https://api.coingecko.com/api/v3/simple/price?ids=bitcoin&vs_currencies=usd";
        Request request = new Request.Builder().url(coinGeckoURI).build();
        client.newCall(request).enqueue(callback);
    }

    private void parseBitcoinPrice(String str) {
        JSONObject jsonObject = new JSONObject(str);
        double currentPrice = jsonObject.getJSONObject("bitcoin").getDouble("usd");
        new Executor().updateCoinValue(currentPrice);
    }
}
