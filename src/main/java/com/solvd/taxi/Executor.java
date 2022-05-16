package com.solvd.taxi;

import com.solvd.taxi.dao.jdbcMySQLImpl.*;
import com.solvd.taxi.models.*;

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
        // Jaxb.writeToXML();

        CustomersDAO customersDAO = new CustomersDAO();
        //customersDAO.getCustomers();
        /*CustomersModel customersModel = new CustomersModel();
        customersModel.setId(6);
        customersModel.setFirstName("Tom");
        customersModel.setLastName("Sawyer");
        customersModel.setRating(5);
        customersModel.setEmail("tom@gmail.com");
        customersModel.setCustomerTypes(new CustomerTypesDAO().getCustomerTypes().getId(6));*/
        //customersDAO.deleteCustomersById(2);
        //customersDAO.getCustomersInnerJoinOrders();


        CustomerTypesDAO customerTypesDAO = new CustomerTypesDAO();
        //customerTypesDAO.getCustomerTypes();
        /*CustomerTypesModel customerTypesModel = new CustomerTypesModel();
        customerTypesModel.setId(6);
        customerTypesModel.setTypes("friend");
        customerTypesModel.setDiscount(20);
        customerTypesDAO.createCustomerTypes(customerTypesModel);*/
   /*     CustomerTypesModel customerTypesModel2 = new CustomerTypesModel();
        customerTypesModel2.setId(6);
        customerTypesModel2.setDiscount(10);
        customerTypesDAO.updateCustomerTypesById(customerTypesModel2);*/
        /*CustomerTypesModel customerTypesModel1 = new CustomerTypesModel(6);
        customerTypesDAO.deleteCustomerTypesById(customerTypesModel1);*/


        CarsDAO carsDAO = new CarsDAO();
       // carsDAO.getCarsModel();

        CarTypesDAO carTypesDAO = new CarTypesDAO();
        //carTypesDAO.getCarTypes();

        CarServicesDAO carServicesDAO = new CarServicesDAO();
        //carServicesDAO.getCarServices();

        CarOrdersDAO carOrdersDAO = new CarOrdersDAO();
        //carOrdersDAO.getCarOrders();



        DriversDAO driversDAO = new DriversDAO();
       // driversDAO.getDrivers();
        //driversDAO.getDriversLeftJoinOrders();

        /*DriversModel driversModel = new DriversModel();
        driversModel.setId(4);
        driversModel.setFirstName("Jim");
        driversModel.setDayOfStart("2022-05-15 00:00:00");
        driversDAO.createDriver(driversModel);*/
        /*DriversModel driversModel1 = new DriversModel();
        driversModel1.setId(4);
        driversModel1.setDayOfStart("2022-05-16 00:00:00");
        driversDAO.updateDriverById(driversModel1);*/
        /*DriversModel driversModel2 = new DriversModel(4);
        driversDAO.deleteDriversById(driversModel2);*/

        LicencesDAO licencesDAO = new LicencesDAO();
        //licencesDAO.getLicences();
       // licencesDAO.getLicencesInnerJoinDrivers();

        CallOperatorsDAO callOperatorsDAO = new CallOperatorsDAO();
        //callOperatorsDAO.getCallOperators();

        AddressesDAO addressesDAO = new AddressesDAO();
        //addressesDAO.getAddresses();

        CitiesDAO citiesDAO = new CitiesDAO();
        //citiesDAO.getCities();
        /*CitiesModel citiesModel = new CitiesModel();
        citiesModel.setId(7);
        citiesModel.setCityName("Miami");
        citiesDAO.createCities(citiesModel);*/
        /*CitiesModel citiesModel1 = new CitiesModel();
        citiesModel1.setId(7);
        citiesModel1.setCityName("LA");
        citiesDAO.updateCitiesById(citiesModel1);*/
        /*CitiesModel citiesModel2 = new CitiesModel(7);
        citiesDAO.deleteCitiesById(citiesModel2);*/


        OrdersDAO ordersDAO = new OrdersDAO();
        //ordersDAO.getOrders();
        //ordersDAO.getOrdersRightJoinDrivers();



    }
}

