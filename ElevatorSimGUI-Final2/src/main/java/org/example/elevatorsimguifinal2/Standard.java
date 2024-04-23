package org.example.elevatorsimguifinal2;

import java.util.ArrayList;

public class Standard implements Elevator{
    private int maxCapcity = 10;

    //Create a list with object type Passenger
    ArrayList<Passenger> passengers;

    public Standard(){
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
