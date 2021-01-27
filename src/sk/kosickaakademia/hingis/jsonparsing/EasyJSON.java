package sk.kosickaakademia.hingis.jsonparsing;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class EasyJSON {
    public void parseJSON(String file) throws IOException {
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader(file)) {
            JSONObject jsonObject = (JSONObject) parser.parse(reader);

            String name = (String) jsonObject.get("name");
            System.out.println(name);
            long age = (long) jsonObject.get("age");
            System.out.println(age);

            JSONArray messages = (JSONArray) jsonObject.get("messages");
            for (Object message : messages) {
                System.out.println(message);
            }
        } catch (ParseException e) { e.printStackTrace(); }
    }

    public void getCurrentWeather(String file){
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader(file)){
            JSONObject jsonObj = (JSONObject) parser.parse(reader);

            String town = (String) jsonObj.get("name");

            System.out.println("City: "+town);

            JSONObject main  = (JSONObject) jsonObj.get("main");

            double temperature = Math.floor((double) main.get("temp") - 273.15);

            System.out.println("Current temperature: "+temperature+"°C");

            long pressure = (long) main.get("pressure");

            System.out.println("Current atmospheric pressure: " + pressure + "hPa");

            long visibility = (long) jsonObj.get("visibility");

            System.out.println("Current visibility: " + visibility + "m");

            long humidity = (long) main.get("humidity");

            System.out.println("Current humidity: "+humidity+"%");

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
    public void getCityData(String wikiData, String filepath){
        JSONParser jsonParser = new JSONParser();

        try {
            Reader reader = new FileReader(filepath);
            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);

            JSONArray data = (JSONArray) jsonObject.get("data");

            JSONObject city = new JSONObject();

            for (int i = 0; i < data.size(); i++) {
                JSONObject tempCity = (JSONObject) data.get(i);
                if(tempCity.get("wikiDataId").equals(wikiData)) {
                    city = tempCity;
                }
            }

            String cityName = (String) city.get("name");

            System.out.println("City name: " + cityName);

            String region = (String) city.get("region");

            System.out.println("Region: " + region);

            double latitude = (double) city.get("latitude");

            System.out.println("latitude: " + latitude);

            double longitude = (double) city.get("longitude");

            System.out.println("longitude: " + longitude);

            System.out.println(city);


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
