package com.solvd.taxi.dao.jdbcMySQLImpl;

import com.solvd.taxi.dao.ILicensesDAO;
import com.solvd.taxi.models.LicensesModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LicensesDAO implements ILicensesDAO {

    private static final Logger LOGGER = LogManager.getLogger(LicensesDAO.class);

    @Override
    public void createLicense(LicensesModel license) {

    }

    @Override
    public void updateLicenseById(int id) {

    }

    @Override
    public void deleteLicenseById(int id) {

    }

    @Override
    public LicensesModel getLicenseById(int id) {
        return null;
    }
}
