package com.parkingLot.projos;

public class ParkingSlot {
    private int slotId;
    private boolean isAvailable;

    public ParkingSlot(int slotId) {
        this.slotId = slotId;
        this.isAvailable = true;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }


    public void parkCar() {
        this.isAvailable = false;
    }

    public void freeSlot() {
        this.isAvailable = true;
    }
}
