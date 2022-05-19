package com.solvd.taxi.models;

import javax.xml.bind.annotation.*;

//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlRootElement(name = "operators")
//@XmlType(propOrder = { "id", "firstName", "lastName" })
public class CallOperatorsModel {
  //  @XmlElement(name = "id")
    private int id;
   // @XmlElement(name = "firstName")
    private String firstName;
   // @XmlElement(name = "lastName")
    private String lastName;


        public CallOperatorsModel() {

    }

    public CallOperatorsModel(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "CallOperatorsModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
