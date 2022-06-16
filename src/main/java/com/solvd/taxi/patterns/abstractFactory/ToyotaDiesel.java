package com.solvd.taxi.patterns.abstractFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ToyotaDiesel implements IDiesel {
    private static final Logger LOGGER = LogManager.getLogger(ToyotaDiesel.class);
    public ToyotaDiesel() {
        LOGGER.info("Diesel is full");
    }

}
