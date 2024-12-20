package com.aersu.weather;

public class WeatherAPI {
    private static final String API_KEY = System.getenv("WEATHER_API");
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/forecast";
}
