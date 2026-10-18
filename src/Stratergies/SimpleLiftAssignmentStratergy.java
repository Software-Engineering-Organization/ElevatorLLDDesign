package Stratergies;

import Entities.Elevator;
import Entities.State;
import Interfaces.ElevatorRequestStratergy;
import Request.UserRequest;

import java.util.List;

public class SimpleLiftAssignmentStratergy implements ElevatorRequestStratergy {
    List<Elevator> elevators;
    UserRequest userRequest;

    SimpleLiftAssignmentStratergy(List<Elevator> elevatorList, UserRequest userReqst){
        elevators = elevatorList;
        userRequest = userReqst;
    }

    // check elevator availability
    public Elevator checkElevatorAvailability(){
        Elevator availableElevator = null;
        availableElevator = findSameDirectionElevator();

        if(availableElevator != null){
            return availableElevator;
        }

        availableElevator = checkIdle();

        return availableElevator;
    }
    // check lift in the UP/DOWN direction for user
    private Elevator findSameDirectionElevator(){

        if(userRequest.getDirection() == State.DOWN){
            for (Elevator lift : elevators){
                if(lift.GetState() == State.DOWN && lift.GetFloor() >= userRequest.getCurrentFloor()){
                    return lift;
                }
            }
        }
        else if(userRequest.getDirection() == State.UP){
            for (Elevator lift : elevators){
                if(lift.GetState() == State.UP && lift.GetFloor() <= userRequest.getCurrentFloor()){
                    return lift;
                }
            }
        }

        return null;
    }

    // check for the IDLE lift
    private Elevator checkIdle(){
        for (Elevator lift : elevators){
            if(lift.GetState() == State.IDLE){
                return lift;
            }
        }
        return null;
    }
}
