package com.solvd.taxi.dao;

import com.solvd.taxi.models.AddressesModel;

public interface IAddressesDAO {
    void createAddresses(AddressesModel addresses);

    void updateAddressesById(AddressesModel addresses);

    void deleteAddressesById(AddressesModel addresses);

    AddressesModel getAddresses();
}
