package com.solvd.taxi.dao;

import com.solvd.taxi.models.DriversModel;
import com.solvd.taxi.models.LicensesModel;

public interface ILicensesDAO {

    void createLicense(LicensesModel license);

    void updateLicenseById(int id);

    void deleteLicenseById(int id);

    LicensesModel getLicenseById(int id);
}
