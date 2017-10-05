package com.nearsoft.javaschool.service;

import com.nearsoft.javaschool.domain.Spot;
import com.nearsoft.javaschool.domain.vehicles.Vehicle;
import com.nearsoft.javaschool.enums.VehicleType;

import java.util.Map;
import java.util.Set;

public interface ParkingLotReporter {

    Map<Spot, Vehicle> getOccupiedParkingSpots();

    Map<String, Vehicle> getVehiclesByLicensePlate();

    Set<VehicleType> getDifferentVehicleTypesParked();
}
