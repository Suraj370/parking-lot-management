package com.parkingLot.services;

import com.parkingLot.daos.ParkingLotDAO;
import com.parkingLot.exceptions.CarNotFoundException;
import com.parkingLot.exceptions.ParkingFullException;
import com.parkingLot.projos.Car;
import com.parkingLot.projos.ParkingSlot;

public class ParkingServiceImpl implements ParkingService {

    private ParkingLotDAO parkingLotDAO;

    public ParkingServiceImpl(ParkingLotDAO parkingLotDAO) {
        this.parkingLotDAO = parkingLotDAO;
    }

    @Override
    public boolean parkCar(Car car) {
        boolean res = parkingLotDAO.parkCar(car);
        if(!res){
            throw new ParkingFullException("Sorry, no available parking slots at the moment.");

        }
        return true;
    }


    @Override
    public boolean freeSlot(String licensePlate) {
        boolean res = parkingLotDAO.freeSlot(licensePlate);
        if(!res){
            throw new CarNotFoundException("car with this license Plate was not found");
        }

        return true;
    }

    @Override
    public ParkingSlot[] getParkingSlot() {
        return parkingLotDAO.getParkingSlot();
    }
}
