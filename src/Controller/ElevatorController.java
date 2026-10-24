package Controller;

import Entities.Elevator;
import Interfaces.ElevatorRequestStratergy;
import Request.UserRequest;

import java.util.List;

public class ElevatorController {
    ElevatorRequestStratergy elevatorRequestStratergy;
    List<Elevator> elevators;

    ElevatorController(ElevatorRequestStratergy elevatorRequestStratergy, List<Elevator> elevators){
        this.elevatorRequestStratergy = elevatorRequestStratergy;
        this.elevators = elevators;
    }

    public void assignElevatorToUserRequest(UserRequest userRequest){
        System.out.println("trying to assign an Elevator to the userRequest");

        boolean isElevatorAssigned = elevatorRequestStratergy.checkElevatorAvailability(elevators, userRequest);

       while(!isElevatorAssigned){
           System.out.println("didn't find any elevator, so trying until finds one");
           isElevatorAssigned = elevatorRequestStratergy.checkElevatorAvailability(elevators, userRequest);
       }

        System.out.println("Request assigned to the Elevator!!");
    }
}
