package com.solvd.taxi.dao;

import com.solvd.taxi.models.LicencesModel;

import java.util.List;

public interface ILicencesDAO {

    void createLicences(LicencesModel licencesModel);

    void updateLicencesById(LicencesModel licencesModel);

    void deleteLicencesById(LicencesModel licencesModel);

    LicencesModel getLicencesById(int id);

    List<LicencesModel> getAllLicences();
}
