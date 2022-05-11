package com.solvd.taxi.dao;

import com.solvd.taxi.models.PersonModel;

public interface IPersonDAO {

    void createPerson(PersonModel person);

    void updatePersonById(int id);

    void deletePersonById(int id);

    PersonModel getPersonById(int id);
}
