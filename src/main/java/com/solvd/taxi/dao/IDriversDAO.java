package com.solvd.taxi.dao;

import com.solvd.taxi.models.CustomersModel;
import com.solvd.taxi.models.DriversModel;

public interface IDriversDAO {

    void createDriver(DriversModel driversModel);

    void updateDriverById(DriversModel driversModel);

    void deleteDriversById(DriversModel driversModel);

    DriversModel getDriversById(int id);
}
