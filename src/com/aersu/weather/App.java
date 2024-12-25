package com.aersu.weather;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, URISyntaxException {
        WeatherAPI weatherAPI = new WeatherAPI();
        Scanner input = new Scanner(System.in);
        System.out.println("Which city you would like to see the weather forecast? : ");
        String city = input.nextLine();

//        System.out.println("Toronto = " + weatherAPI.getForecast("Toronto"));
        WeatherResponseParser parser = new WeatherResponseParser();
        parser.parsePrint(weatherAPI.getForecast(city));
    }
}
