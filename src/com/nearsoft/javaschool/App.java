package com.nearsoft.javaschool;

import com.nearsoft.javaschool.domain.Car;
import com.nearsoft.javaschool.domain.Motorcycle;
import com.nearsoft.javaschool.domain.ParkingLot;
import com.nearsoft.javaschool.domain.Vehicle;
import com.nearsoft.javaschool.enums.CarType;
import com.nearsoft.javaschool.service.ParkingLotService;
import com.nearsoft.javaschool.service.impl.ParkingLotServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pruiz on 9/21/17.
 */
public class App {

    public static void main(String[] args) throws InterruptedException {

        // Create a new parking lot
        ParkingLot parkingLot = new ParkingLot("Java School", 3);

        // Initialize the service to perform operations
        ParkingLotService parkingLotService = new ParkingLotServiceImpl(parkingLot);

        System.out.println("Total of available spots: " + parkingLotService.getFreeSpots());

        //creates vehicles
        List<Vehicle> cars = new ArrayList<>();
        cars.add(new Car(CarType.SUV));
        cars.add(new Car(CarType.SEDAN, "UK-2348"));
        cars.add(new Motorcycle());
        cars.add(new Car());

        for (Vehicle car : cars) {

            System.out.println("Total of available spots: " + parkingLotService.getFreeSpots());
            if (parkingLotService.park(car)) {
                System.out.println("The car: " + car.getPlates() + " was parked successfully.");
            } else {
                System.out.println("There is no empty space to park.");
            }
        }

        for (Vehicle car : cars) {

            System.out.println("Total of available spots: " + parkingLotService.getFreeSpots());
            double fare = parkingLotService.clearSpot(car);
            if (fare > 0) {
                System.out.println("Total fare: " + fare);
                System.out.println("The car: " + car.getPlates() + " was unparked successfully.");
            } else {
                System.out.println("The car was not founded.");
            }
        }

        System.out.println("Total of available spots: " + parkingLotService.getFreeSpots());

    }

}
