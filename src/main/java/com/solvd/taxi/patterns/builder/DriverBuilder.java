package com.solvd.taxi.patterns.builder;

public class DriverBuilder {
    private int id;
    private String firstName;
    private String dayOfStart;

    public DriverBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public DriverBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public DriverBuilder setDayOfStart(String dayOfStart) {
        this.dayOfStart = dayOfStart;
        return this;
    }
    public Driver getDriver() {
        return new Driver(id,firstName,dayOfStart);
    }
}
