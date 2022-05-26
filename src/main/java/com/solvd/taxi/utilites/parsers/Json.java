package com.solvd.taxi.utilites.parsers;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.solvd.taxi.models.CitiesModel;
import org.apache.logging.log4j.LogManager;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.Logger;

public class Json {

    private static final Logger LOGGER = LogManager.getLogger(Json.class);

    public static void main(String[] args) {
       //writeToJson();
       //readFromJson();
    }

    public static void writeToJson() {

        CitiesModel citiesModel = new CitiesModel();
        citiesModel.setId(5);
        citiesModel.setCityName("Boston");

/*
        List<String> addresses = new ArrayList<String>();
        addresses.add("university");
        addresses.add("city centre");
        addresses.add("downtown");
        citiesModel.setAddresses(addresses);
*/

        try {

            ObjectMapper mapper = new ObjectMapper();

            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());

            //mapper.writeValue(Paths.get("src/main/resources/json/write.json").toFile(), citiesModel);
            writer.writeValue(Paths.get("src/main/resources/json/write.json").toFile(), citiesModel);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static void readFromJson() {
        CitiesModel citiesModel= new CitiesModel();
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON string to Book object
            citiesModel = mapper.readValue(Paths.get("src/main/resources/json/read.json").toFile(), CitiesModel.class);

            // print book
            LOGGER.info(citiesModel);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}


