package com.nearsoft.javaschool.repository;

import com.nearsoft.javaschool.domain.vehicles.Vehicle;

import java.util.List;

public class ParkingLotRepository {

    private static ParkingLotRepository parkingLotRepository;

    private ParkingLotRepository() {

    }

    public static ParkingLotRepository getParkingLotRepository() {
        if (parkingLotRepository == null) {
            parkingLotRepository = new ParkingLotRepository();
        }
        return parkingLotRepository;
    }


    public List<Vehicle> getVehicles() {
        return null;
    }

    public void setVehicles(List<Vehicle> vehicles) {

    }

    public void addVehicle(Vehicle vehicle) {

    }
}
