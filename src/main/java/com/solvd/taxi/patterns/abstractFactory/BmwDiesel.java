package com.solvd.taxi.patterns.abstractFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BmwDiesel implements IDiesel {
    private static final Logger LOGGER = LogManager.getLogger(BmwDiesel.class);
    public BmwDiesel() {
        LOGGER.info("Diesel is full");
    }

}
