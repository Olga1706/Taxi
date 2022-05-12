package com.solvd.taxi.utilites.parsers;

import com.solvd.taxi.dao.jdbcMySQLImpl.AddressesDAO;
import com.solvd.taxi.models.DriversModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class SaxReader {

    private static final Logger LOGGER = LogManager.getLogger(AddressesDAO.class);


    public static void main(String[] args) {


        try {
            File inputFile = new File("src/main/resources/xml/empty.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            UserHandler userhandler = new UserHandler();
            saxParser.parse(inputFile, userhandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class UserHandler extends DefaultHandler {

    boolean id = false;
    boolean firstName = false;
    boolean lastName = false;
    boolean dayOfStart = false;


    @Override
    public void startElement(
            String uri, String localName, String qName, Attributes attributes) {

        if (qName.equalsIgnoreCase("driver")) {
            System.out.println("Drivers");
        } else if (qName.equalsIgnoreCase("id")) {
            id = true;
        } else if (qName.equalsIgnoreCase("firstName")) {
            firstName = true;
        } else if (qName.equalsIgnoreCase("lastName")) {
            lastName = true;
        }
        else if (qName.equalsIgnoreCase("dayOfStart")) {
            dayOfStart = true;
        }
    }

    @Override
    public void endElement(String uri,
                           String localName, String qName) {

        if (qName.equalsIgnoreCase("driver")) {
            System.out.println("End Element :" + qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        DriversModel driver= new DriversModel(0,"","","");
        if (id) {
            driver.setId(Integer.parseInt(new String(ch, start, length)));
            System.out.println("Id: "+driver.getId());
            id = false;
        } else if (firstName) {
            driver.setFirstName(new String(ch, start, length));
            System.out.println("First name: "+driver.getFirstName());
            firstName = false;
        } else if (lastName) {
            driver.setLastName(new String(ch, start, length));
            System.out.println("Last name: "+driver.getLastName());
            lastName = false;
        } else if (dayOfStart) {
            driver.setDayOfStart(new String(ch, start, length));
            System.out.println("Day Of Start: "+driver.getDayOfStart());
            dayOfStart = false;
        }
    }
}
