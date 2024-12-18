package com.parkingLot.controller;

import com.parkingLot.projos.Car;
import com.parkingLot.projos.ParkingSlot;
import com.parkingLot.services.ParkingService;

import java.util.Scanner;

public class ParkingController {

    private ParkingService parkingService;

    public ParkingController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    public void start()
    {

        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            System.out.println("\n--- Parking Lot Management System ---");
            System.out.println("1.  View Available Parking Slots");
            System.out.println("2.  Park a car");
            System.out.println("3.  Free a Parking Slots");
            System.out.println("4.  EXIT");
            System.out.println(" choose your option ");

            int option = scanner.nextInt();

            scanner.nextLine();

            switch(option)
            {
                case 1:
                    ParkingSlot[] parkingSlots = parkingService.getParkingSlot();
                    if (parkingSlots.length == 0){
                        System.out.println("No Slots Available at the moment.");
                    }
                    else {
                        System.out.println("Available Parking Slots:");
                        for(ParkingSlot slot:parkingSlots)
                        {
                            if(slot.isAvailable())
                            {
                                System.out.println("Slot ID: "+ slot.getSlotId());
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println(" enter license plate number");
                    String licensePlateEntry = scanner.nextLine();
                    Car car  = new Car(licensePlateEntry);
                     if(parkingService.parkCar(car)){
                         System.out.println("Car parked successfully");
                     }
                     else{
                         System.out.println("Sorry, no available parking slots at the moment.");
                     }
                    break;

                case 3:
                    System.out.println(" enter license plate number");
                    String licensePlateExit = scanner.nextLine();
                    if(parkingService.freeSlot(licensePlateExit)){
                        System.out.println("Car has exited the parking lot successfully");


                    }
                    else {
                        System.out.println("car with this license Plate was not found");
                    }
                    break;
                case 4:
                    scanner.close();
                    return;
                default :
                    System.out.println("invalid input, try again !");
            }
        }


    }

}
