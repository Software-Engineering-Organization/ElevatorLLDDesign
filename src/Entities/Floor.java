package Entities;

import Controller.ElevatorController;

public class Floor {
    int floorNumber;
    ExternalButton externalButton;

    Floor(int floorNumber, ExternalButton externalButton){
        this.floorNumber = floorNumber;
        this.externalButton = externalButton;
    }
}
