package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.ICallOperatorsDAO;
import com.solvd.taxi.models.CallOperatorsModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CallOperatorsDAO implements ICallOperatorsDAO {

    private static final Logger LOGGER = LogManager.getLogger(CallOperatorsDAO.class);

    @Override
    public void createCallOperators(CallOperatorsModel callOperators) {

    }

    @Override
    public void updateCallOperatorsById(int id) {

    }

    @Override
    public void deleteCallOperatorsById(int id) {

    }

    @Override
    public CallOperatorsModel getCallOperatorsById(int id) {
        return null;
    }
}
