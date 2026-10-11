package Entities;

import Controller.ElevatorController;

public class ExternalButton {
    ElevatorController elevatorController;

    ExternalButton(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }
}
