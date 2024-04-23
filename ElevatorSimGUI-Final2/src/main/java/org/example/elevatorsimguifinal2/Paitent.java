package org.example.elevatorsimguifinal2;

public class Paitent implements Passenger {

    private int startingFloor;
    private int endingFloor;

    public Paitent(){

    }
    public Paitent(int _startingFloor, int _endingFloor) {
        this.startingFloor = _startingFloor;
        this.endingFloor = _endingFloor;
    }

    @Override
    public int getPickupFloor() {
        return startingFloor;
    }

    @Override
    public int getDroppedFloor() {
        return endingFloor;
    }

    @Override
    public boolean isStaff() {
        return false;
    }
}