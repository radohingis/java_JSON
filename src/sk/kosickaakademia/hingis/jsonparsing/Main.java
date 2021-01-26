package sk.kosickaakademia.hingis.jsonparsing;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        EasyJSON easyJSON = new EasyJSON();

        try {
            easyJSON.parseJSON("C:\\Users\\lenovo\\IdeaProjects\\JSON\\resources\\users.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
