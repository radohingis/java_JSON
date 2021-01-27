package sk.kosickaakademia.hingis.jsonparsing;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        EasyJSON easyJSON = new EasyJSON();

//        easyJSON.getCurrentWeather("./resources/kosice_current_weather.json");

        easyJSON.getCityData("Q25409", "./resources/cities_slovak.json");
    }
}
