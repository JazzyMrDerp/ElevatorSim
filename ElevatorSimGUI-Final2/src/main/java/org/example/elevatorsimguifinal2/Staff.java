package org.example.elevatorsimguifinal2;

public class Staff implements Passenger{
    private int startingFloor;
    private int endingFloor;

    public Staff(){

    }
    public Staff(int _startingFloor, int _endingFloor) {
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
        return true;
    }

}
