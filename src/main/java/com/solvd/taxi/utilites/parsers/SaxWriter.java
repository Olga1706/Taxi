package com.solvd.taxi.utilites.parsers;

//import com.solvd.taxi.models.DriversModel;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class SaxWriter {
  /*  public static void writeXML()throws FileNotFoundException, XMLStreamException {
        DriversModel driver= new DriversModel(1,"John","Smith","11/03/2022");
        driver.setId(1);
        driver.setFirstName("John");
        driver.setLastName("Smith");
        driver.setDayOfStart("11/03/2022");
        XMLOutputFactory factory= XMLOutputFactory.newFactory();
        XMLStreamWriter writer=factory.createXMLStreamWriter(new FileOutputStream("src/main/resources/xml/empty.xml"));
        writer.writeStartDocument();
        writer.writeCharacters("\n");
        writer.writeStartElement("driver");
        writer.writeCharacters("\n\t");

        writer.writeStartElement("id");
        writer.writeCharacters(String.valueOf(driver.getId()));
        writer.writeEndElement();

        writer.writeCharacters("\n\t");
        writer.writeStartElement("firstName");
        writer.writeCharacters(driver.getFirstName());
        writer.writeEndElement();

        writer.writeCharacters("\n\t");
        writer.writeStartElement("lastName");
        writer.writeCharacters(driver.getLastName());
        writer.writeEndElement();

        writer.writeCharacters("\n\t");
        writer.writeStartElement("dayOfStart");
        writer.writeCharacters(driver.getDayOfStart());

        writer.writeEndElement();
        writer.writeCharacters("\n");
        writer.writeEndElement();
        writer.writeEndDocument();
    }
*/
}
