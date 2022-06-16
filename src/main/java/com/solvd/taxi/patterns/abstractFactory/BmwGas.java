package com.solvd.taxi.patterns.abstractFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BmwGas implements IGas{
    private static final Logger LOGGER = LogManager.getLogger(BmwGas.class);
    public BmwGas() {
        LOGGER.info("Gas is full");
    }

}
