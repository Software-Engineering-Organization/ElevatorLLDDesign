package Entities;

import Controller.ElevatorController;
import Request.UserRequest;

public class ExternalButton {
    ElevatorController elevatorController;

    ExternalButton(ElevatorController elevatorController){
        this.elevatorController = elevatorController;
    }

    public void placeUserRequest(UserRequest userRequest){
        elevatorController.assignElevatorToUserRequest(userRequest);
        System.out.println("Request served successfully!!");
        return;
    }

}
