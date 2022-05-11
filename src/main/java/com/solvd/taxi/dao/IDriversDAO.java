package com.solvd.taxi.dao;

import com.solvd.taxi.models.CustomersModel;
import com.solvd.taxi.models.DriversModel;

public interface IDriversDAO {

    void createDriver(DriversModel driver);

    void updateDriverById(int id);

    void deleteDriversById(int id);

    DriversModel getDriverById(int id);
}
