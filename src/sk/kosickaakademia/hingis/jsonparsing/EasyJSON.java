package sk.kosickaakademia.hingis.jsonparsing;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
}
