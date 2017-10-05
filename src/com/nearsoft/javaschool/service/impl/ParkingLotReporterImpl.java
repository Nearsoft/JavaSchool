package com.nearsoft.javaschool.service.impl;

import com.nearsoft.javaschool.domain.ParkingLot;
import com.nearsoft.javaschool.domain.Spot;
import com.nearsoft.javaschool.domain.vehicles.Vehicle;
import com.nearsoft.javaschool.enums.VehicleType;
import com.nearsoft.javaschool.repository.ParkingLotRepository;
import com.nearsoft.javaschool.service.ParkingLotReporter;

import java.util.Map;
import java.util.Set;

public class ParkingLotReporterImpl implements ParkingLotReporter {

    private static ParkingLot parkingLot;
    private static ParkingLotRepository parkingLotRepository;

    public ParkingLotReporterImpl(ParkingLot parkingLot, ParkingLotRepository parkingLotRepository){
        this.parkingLot = parkingLot;
        this.parkingLotRepository = parkingLotRepository;
    }

    @Override
    public Map<Spot, Vehicle> getOccupiedParkingSpots() {
        return null;
    }

    @Override
    public Map<String, Vehicle> getVehiclesByLicensePlate() {
        return null;
    }

    @Override
    public Set<VehicleType> getDifferentVehicleTypesParked() {
        return null;
    }
}
