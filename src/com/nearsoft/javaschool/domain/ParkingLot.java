package com.nearsoft.javaschool.domain;


import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingLot {

    private Spot[] spots;
    private String name;

    public ParkingLot(String name, int numberOfSpots) {
        this.name = name;
        initializeSpots(numberOfSpots);
    }

    private void initializeSpots(int numberOfSpots) {
        this.spots = new Spot[numberOfSpots];
        for (int i = 0; i < spots.length; i++) {
            spots[i] = new Spot(i + 1);
        }
    }

    public Spot[] getSpots() {
        return spots;
    }

    public void setSpots(Spot[] spots) {
        this.spots = spots;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        ParkingLot that = (ParkingLot) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public int getFreeSpots() {
        int freeSpots = 0;
        for (Spot spot : spots) {
            if (spot.isAvailable()) {
                freeSpots++;
            }
        }
        return freeSpots;
    }

    public boolean park(Vehicle car) {

        if (getFreeSpots() > 0) {
            for (int i = 0; i < spots.length; i++) {
                if (spots[i].isAvailable()) {
                    spots[i].setCar(car);
                    break;
                }
            }
            return true;
        } else {
            return false;
        }

    }

    public double clearSpot(Vehicle vehicle) {

        double fare = 0.0;
        for (int i = 0; i < spots.length; i++) {
            if (spots[i].getCar() == null)
                continue;

            if (spots[i].getCar().equals(vehicle)) {

                double diff = Math.ceil(Duration.between(spots[i].getArrivalTime(), LocalDateTime.now()).toMinutes() / 60);

                fare = spots[i].getCar().getHourPrice() * diff;

                spots[i].setCar(null);

                return fare;
            }
        }
        return fare;

    }
}
