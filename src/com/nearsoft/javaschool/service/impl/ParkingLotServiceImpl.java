package com.nearsoft.javaschool.service.impl;

import com.nearsoft.javaschool.domain.ParkingLot;
import com.nearsoft.javaschool.domain.Spot;
import com.nearsoft.javaschool.domain.Vehicle;
import com.nearsoft.javaschool.service.ParkingLotService;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by obautista on 9/22/17.
 */
public class ParkingLotServiceImpl implements ParkingLotService {

    private static ParkingLot parkingLot;

    public ParkingLotServiceImpl(ParkingLot parkingLot){
        this.parkingLot = parkingLot;
    }

    public int getFreeSpots() {
        int freeSpots = 0;
        for (Spot spot : parkingLot.getSpots()) {
            if (spot.isAvailable()) {
                freeSpots++;
            }
        }
        return freeSpots;
    }

    public boolean park(Vehicle car) {
        Spot[] spots = parkingLot.getSpots();
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
        Spot[] spots = parkingLot.getSpots();
        double fare = 0.0;
        for (int i = 0; i < spots.length; i++) {
            if (spots[i].getCar() == null)
                continue;

            if (spots[i].getCar().equals(vehicle)) {

                double diff = Math.ceil(
                        Duration.between(spots[i].getArrivalTime(), LocalDateTime.now()).toMinutes() / 60);

                fare = spots[i].getCar().getHourPrice() * diff;

                spots[i].setCar(null);

                return fare;
            }
        }
        return fare;

    }
}
