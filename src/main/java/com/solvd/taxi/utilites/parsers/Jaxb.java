package com.solvd.taxi.utilites.parsers;

import com.solvd.taxi.models.CallOperatorsModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Jaxb {
    public static void writeToXML() throws JAXBException {
        final Logger LOGGER = LogManager.getLogger(Jaxb.class);
       // CallOperatorsModel operators = new CallOperatorsModel(3,"John", "Smith");
        CallOperatorsModel operators = new CallOperatorsModel();
        operators.setId(3);
        operators.setFirstName("John");
        operators.setLastName("Smith");
        File file = new File("src/main/resources/xml/EmptyJaxb.xml");
        try {
            JAXBContext context = JAXBContext.newInstance(CallOperatorsModel.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(operators, file);
            LOGGER.info("Writing to the file successfully executed");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void readFromXML() {
        final Logger LOGGER = LogManager.getLogger(Jaxb.class);
        File file = new File("src/main/resources/xml/FullJaxb.xml");
        try {
            JAXBContext context = JAXBContext.newInstance(CallOperatorsModel.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            CallOperatorsModel operatorsNew = (CallOperatorsModel) unmarshaller.unmarshal(file);
            if (operatorsNew != null) LOGGER.info(operatorsNew.toString());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
