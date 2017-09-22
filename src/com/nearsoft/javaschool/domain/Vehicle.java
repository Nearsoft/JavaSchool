package com.nearsoft.javaschool.domain;

public abstract class Vehicle {

    private String plates;

    private int numberOfWheels;

    public Vehicle(int numberOfWheels, String plates) {
        this.numberOfWheels = numberOfWheels;
        this.plates = plates;
    }

    public String getPlates() {
        return plates;
    }

    public void setPlates(String plates) {
        this.plates = plates;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }

    public abstract float getHourPrice();

}
