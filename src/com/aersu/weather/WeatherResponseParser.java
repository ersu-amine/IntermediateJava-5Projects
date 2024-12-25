package com.aersu.weather;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class WeatherResponseParser {
    public void parsePrint(String responseJSON){
        JSONObject jsonObject = new JSONObject(responseJSON);

        //if request is successful, display
        if(jsonObject.getInt("cod") == 200){
            System.out.println("Weather forecast for city: ");
            JSONArray forecasts = jsonObject.getJSONArray("list");
            for (int i = 0; i < forecasts.length(); i++) {
                JSONObject dayForecast = forecasts.getJSONObject(i);
                long timestamp = dayForecast.getLong("dt");
                String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date(timestamp * 1000));
                double temp = dayForecast.getJSONObject("main").getDouble("temp");
                int pressure = dayForecast.getJSONObject("main").getInt("pressure");
                int humidity = dayForecast.getJSONObject("main").getInt("humidity");
                String description = dayForecast.getJSONArray("weather").getJSONObject(0).getString("description");

                System.out.println(date + ": " +temp + " celcius, " + pressure + " pressure, " + humidity + " humiditiy, "+ description);


            }

        }else{
            System.out.println("Cannot print the request");
        }
    }
}
