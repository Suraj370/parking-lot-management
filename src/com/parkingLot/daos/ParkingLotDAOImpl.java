package com.parkingLot.daos;

import com.parkingLot.projos.Car;
import com.parkingLot.projos.ParkingSlot;
import com.parkingLot.projos.ParkingTicket;

public class ParkingLotDAOImpl implements ParkingLotDAO{
    private ParkingSlot[] slots;
    private ParkingTicket[] tickets;
    private int ticketCount;


    public ParkingLotDAOImpl(ParkingSlot[] slots, ParkingTicket[] tickets) {
        this.slots = slots;
        this.tickets = tickets;
        this.ticketCount = 0;
    }

    @Override
    public boolean parkCar(Car car) {
        ParkingSlot slot = findAvailableSlot();
        if(slot != null)
        {
            slot.parkCar();
            ParkingTicket ticket = new ParkingTicket(car, slot);
            tickets[ticketCount++]= ticket;
            showTicketDetails(ticket);
        }
        else{
            return false;
        }

        return true;
    }



    @Override
    public boolean freeSlot(String licensePlate) {
        ParkingTicket ticket = findTicketByLicensePlate(licensePlate);
        if(ticket != null)
        {
            ticket.setExitTime();
            ticket.getSlot().freeSlot();
            showParkingExit(ticket);
        }
        else
        {
            return false;
        }

        return true;
    }

    @Override
    public ParkingSlot[] getParkingSlot() {
        ParkingSlot[] availableSlots = new ParkingSlot[slots.length];
        System.arraycopy(slots, 0, availableSlots, 0, slots.length);
        if(slots.length == 0){
            return null;
        }
        return availableSlots;
    }


    private void showTicketDetails(ParkingTicket ticket) {
        System.out.println("license Plate: "+ticket.getCar().getLicensePlate());
        System.out.println("slot ID: "+ticket.getSlot().getSlotId());
        System.out.println("Entry Time : "+ticket.getEntryTime());

    }

    private void showParkingExit(ParkingTicket ticket) {
        System.out.println("license Plate: "+ticket.getCar().getLicensePlate());
        System.out.println("slot ID: "+ticket.getSlot().getSlotId());
        System.out.println("Entry Time : "+ticket.getEntryTime());
        System.out.println("Exit Time : "+ticket.getExitTime());
        System.out.println("Parking Charge : $ "+ticket.getParkingCharge());


    }



    private ParkingTicket findTicketByLicensePlate(String licensePlate) {
        for(int i =0 ; i < ticketCount; i++) {

            if(tickets[i].getCar().getLicensePlate().equals(licensePlate)) {
                return tickets[i];
            }
        }
        return null;
    }



    private ParkingSlot findAvailableSlot() {
        for(ParkingSlot slot:slots)
        {
            if(slot.isAvailable())
            {
                return slot;
            }
        }
        return null;
    }
}
