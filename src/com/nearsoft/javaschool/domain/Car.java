package com.nearsoft.javaschool.domain;

import com.nearsoft.javaschool.enums.CarType;

/**
 * This example shows the interaction with the Constructors
 * on the same class and the super class.
 */
public class Car extends Vehicle {

    private CarType type = CarType.SEDAN;

    public Car() {
        this(CarType.SEDAN);
    }

    public Car(CarType type) {
        this(type, "UNDEFINED");
    }

    public Car(CarType type, String plates){
        super(4,plates);
        this.type = type;
    }

    public CarType getType() {
        return type;
    }

    public void setType(CarType type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Car car = (Car) o;

        if (getPlates() != null ? !getPlates().equals(car.getPlates()) : car.getPlates() != null)
            return false;
        return type == car.type;
    }

    @Override
    public int hashCode() {
        int result = getPlates() != null ? getPlates().hashCode() : 0;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public float getHourPrice() {
        switch (type) {
            case SEDAN:
                return 12;
            default:
                return 15;
        }

    }
}
