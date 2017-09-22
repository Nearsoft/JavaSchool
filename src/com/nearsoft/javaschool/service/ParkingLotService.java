package com.nearsoft.javaschool.service;

import com.nearsoft.javaschool.domain.Vehicle;

/**
 * Created by obautista on 9/22/17.
 */
public interface ParkingLotService {

    int getFreeSpots();

    boolean park(Vehicle car);

    double clearSpot(Vehicle vehicle);

}
