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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;


public class Executor {

    private static final Logger LOGGER = LogManager.getLogger(Executor.class);


    public static void main(String[] args) throws FileNotFoundException, XMLStreamException, JAXBException {
        //SaxWriter.writeXML();
        // Jaxb.writeToXML();

        CustomersDAO customersDAO = new CustomersDAO();
        //LOGGER.info(customersDAO.getCustomersById(2));
        //customersDAO.getAllCustomers();
        /*CustomersModel customersModel = new CustomersModel();
        customersModel.setId(6);
        customersModel.setFirstName("Tom");
        customersModel.setLastName("Sawyer");
        customersModel.setRating(5);
        customersModel.setEmail("tom@gmail.com");
        customersModel.setCustomerTypes(new CustomerTypesDAO().getCustomerTypesById(5));
        customersDAO.createCustomers(customersModel)*/;
        /*CustomersModel customersModel1 = new CustomersModel(6);
        customersDAO.deleteCustomersById(customersModel1);*/

        //LOGGER.info( customersDAO.getCustomersInnerJoinOrders());


        CustomerTypesDAO customerTypesDAO = new CustomerTypesDAO();
       //LOGGER.info(customerTypesDAO.getCustomerTypesById(2));
        /*CustomerTypesModel customerTypesModel = new CustomerTypesModel();
        customerTypesModel.setId(6);
        customerTypesModel.setTypes("friend");
        customerTypesModel.setDiscount(20);
        customerTypesDAO.createCustomerTypes(customerTypesModel);*/
   /*   CustomerTypesModel customerTypesModel2 = new CustomerTypesModel();
        customerTypesModel2.setId(6);
        customerTypesModel2.setDiscount(10);
        customerTypesDAO.updateCustomerTypesById(customerTypesModel2);*/
        /*CustomerTypesModel customerTypesModel1 = new CustomerTypesModel(6);
        customerTypesDAO.deleteCustomerTypesById(customerTypesModel1);*/


        CarsDAO carsDAO = new CarsDAO();
        //carsDAO.getAllCars();
        //LOGGER.info( carsDAO.getCarsModelById(2));

        CarTypesDAO carTypesDAO = new CarTypesDAO();
        //carTypesDAO.getALLCarTypes();
        //LOGGER.info(carTypesDAO.getCarTypesById(2));

        CarServicesDAO carServicesDAO = new CarServicesDAO();
        //carServicesDAO.getCarServicesById(1);

        CarOrdersDAO carOrdersDAO = new CarOrdersDAO();
       // carOrdersDAO.getAllCarOrders();
       // LOGGER.info(carOrdersDAO.getCarOrdersById(1));



        DriversDAO driversDAO = new DriversDAO();
        //LOGGER.info(driversDAO.getDriversById(1));
        //driversDAO.getAllDrivers();

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
        //licencesDAO.getAllLicences();
        //LOGGER.info(licencesDAO.getLicencesById(2));

        CallOperatorsDAO callOperatorsDAO = new CallOperatorsDAO();
        //LOGGER.info(callOperatorsDAO.getALLCallOperators());
        //LOGGER.info(callOperatorsDAO.getCallOperatorsById(1));


        AddressesDAO addressesDAO = new AddressesDAO();
        //LOGGER.info(addressesDAO.getAddressesById(2));
        //addressesDAO.getAllAddresses();

        CitiesDAO citiesDAO = new CitiesDAO();
        //citiesDAO.getAllCities();
        //LOGGER.info(citiesDAO.getCitiesById(2));
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
        //LOGGER.info(ordersDAO.getOrdersById(2));
        //ordersDAO.getAllOrders();
        //ordersDAO.getOrdersRightJoinDrivers();

    }
}

