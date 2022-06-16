package com.solvd.taxi.patterns.abstractFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ToyotaGas implements IGas {
    private static final Logger LOGGER = LogManager.getLogger(ToyotaGas.class);
    public ToyotaGas() {
        LOGGER.info("Gas is full");
    }

}
