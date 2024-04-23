package org.example.elevatorsimguifinal2;

import java.util.ArrayList;

public class Express implements Elevator {
    private int maxCapcity = 8;
    ArrayList<Passenger> passengers;

    public Express() {
        this.passengers = new ArrayList<>();
    }

    @Override
    public void pickUp(Passenger passenger) {
        passengers.add(passenger);
    }

    @Override
    public void dropOff(Passenger passenger) {
        passengers.remove(passenger);
    }

    @Override
    public boolean ablePickup() {
        //if true then can pick up
        return passengers.size() < maxCapcity;
    }


}