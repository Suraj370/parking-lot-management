package com.parkingLot.projos;

import java.time.LocalDateTime;

public class Car {
    private String licensePlate;
    private LocalDateTime entryTime;

    public Car(String licensePlate) {
        this.licensePlate = licensePlate;
        this.entryTime = LocalDateTime.now();
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    @Override
    public String toString() {
        return "Car[" +
                "licensePlate='" + licensePlate + '\'' +
                ", entryTime=" + entryTime +
                ']';
    }
}
