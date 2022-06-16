package com.solvd.taxi.patterns.factory;

public class Factory {
    public IPerson getPerson(String inputPerson) {
        IPerson person = null;
        if (inputPerson.equals("driver")) {
            person = new Driver();
        } else if (inputPerson.equals("customer")) {
            person = new Driver();
        }
        return person;
    }
}
