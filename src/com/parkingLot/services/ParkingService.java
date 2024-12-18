package com.parkingLot.services;

import com.parkingLot.projos.Car;
import com.parkingLot.projos.ParkingSlot;

public interface ParkingService {

    boolean parkCar(Car car);
    boolean freeSlot(String licensePlate);
    ParkingSlot[] getParkingSlot();

}
