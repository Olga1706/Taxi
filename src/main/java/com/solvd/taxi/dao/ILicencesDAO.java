package com.solvd.taxi.dao;

import com.solvd.taxi.models.LicencesModel;

public interface ILicencesDAO {

    void createLicences(LicencesModel licencesModel);

    void updateLicencesById(LicencesModel licencesModel);

    void deleteLicencesById(LicencesModel licencesModel);

    LicencesModel getLicences();
}
