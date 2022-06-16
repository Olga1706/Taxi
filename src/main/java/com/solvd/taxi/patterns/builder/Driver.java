package com.solvd.taxi.patterns.builder;

public class Driver {
    private int id;
    private String firstName;
    private String dayOfStart;

    public Driver(int id, String firstName, String dayOfStart) {
        this.id = id;
        this.firstName = firstName;
        this.dayOfStart = dayOfStart;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", dayOfStart='" + dayOfStart + '\'' +
                '}';
    }
}
