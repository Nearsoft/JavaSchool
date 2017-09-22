package com.nearsoft.javaschool.domain;

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

}
