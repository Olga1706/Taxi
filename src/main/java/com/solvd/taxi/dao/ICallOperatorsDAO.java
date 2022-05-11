package com.solvd.taxi.dao;

import com.solvd.taxi.models.AddressesModel;
import com.solvd.taxi.models.CallOperatorsModel;

public interface ICallOperatorsDAO {

    void createCallOperators(CallOperatorsModel callOperators);

    void updateCallOperatorsById(int id);

    void deleteCallOperatorsById(int id);

    CallOperatorsModel getCallOperatorsById(int id);
}
