package com.parkingLot.daos;

import com.parkingLot.projos.Car;
import com.parkingLot.projos.ParkingSlot;

public interface ParkingLotDAO {

    boolean parkCar(Car car);
    boolean freeSlot(String licensePlate);
    ParkingSlot[] getParkingSlot();

}
