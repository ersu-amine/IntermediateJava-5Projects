package com.aersu.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class WeatherAPI {
    private static final String API_KEY = System.getenv("WEATHER_API");
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/forecast";

    public String getForecast(String city) throws IOException, URISyntaxException {
        String endpoint = BASE_URL + "?q=" +URLEncoder.encode( city, StandardCharsets.UTF_8.toString()) + "&appid=" + API_KEY+"&units=metric";

        URI url = new URI(endpoint);
        HttpURLConnection connection = (HttpURLConnection) url.toURL().openConnection();

        //setting the type of request
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null){
            response.append(line);
        }
        reader.close();
        return response.toString();
    }
}
