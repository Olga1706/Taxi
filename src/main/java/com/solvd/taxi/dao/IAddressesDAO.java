package com.solvd.taxi.dao;

import com.solvd.taxi.models.AddressesModel;

public interface IAddressesDAO {
    void createAddresses(AddressesModel addresses);

    void updateAddressesById(int id);

    void deleteAddressesById(int id);
    AddressesModel getAddressesById(int id);
}
