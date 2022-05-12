package com.solvd.taxi;

import com.solvd.taxi.dao.jdbcMySQLImpl.CustomersDAO;
import com.solvd.taxi.models.DriversModel;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.solvd.taxi.utilites.parsers.Jaxb;
import com.solvd.taxi.utilites.parsers.SaxReader;
import com.solvd.taxi.utilites.parsers.SaxWriter;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


public class Executor {


    public static void main(String[] args) throws FileNotFoundException, XMLStreamException, JAXBException {
        //SaxWriter.writeXML();
        CustomersDAO customersDAO = new CustomersDAO();
        customersDAO.updateCustomerById(5,2);

        //customersDAO.deleteCustomerById(2);
        Jaxb.writeToXML();

    }
}

