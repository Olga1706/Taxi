package com.solvd.taxi.dao;

import com.solvd.taxi.models.AddressesModel;
import com.solvd.taxi.models.CallOperatorsModel;

import java.util.List;

public interface ICallOperatorsDAO {

    void createCallOperators(CallOperatorsModel callOperators);

    void updateCallOperatorsById(CallOperatorsModel callOperators);

    void deleteCallOperatorsById(CallOperatorsModel callOperators);

    CallOperatorsModel getCallOperatorsById(int id);
}
