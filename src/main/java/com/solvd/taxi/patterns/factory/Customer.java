package com.solvd.taxi.patterns.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Customer implements IPerson{
    private static final Logger LOGGER = LogManager.getLogger(Customer.class);

    @Override
    public void getPerson() {
        LOGGER.info("It is a customer");
    }
}
