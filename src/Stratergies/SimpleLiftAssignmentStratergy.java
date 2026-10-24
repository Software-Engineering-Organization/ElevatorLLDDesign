package Stratergies;

import Entities.Elevator;
import Entities.State;
import Interfaces.ElevatorRequestStratergy;
import Request.UserRequest;

import java.util.List;

public class SimpleLiftAssignmentStratergy implements ElevatorRequestStratergy {

    // check elevator availability
    public boolean checkElevatorAvailability(List<Elevator> elevators, UserRequest userRequest){
        Elevator availableElevator = null;
        boolean requestServed = findSameDirectionElevator(elevators, userRequest);

        if(requestServed){
            return requestServed;
        }

        return checkIdle(elevators, userRequest);
    }
    // check lift in the UP/DOWN direction for user
    private boolean findSameDirectionElevator(List<Elevator> elevators, UserRequest userRequest){

        if(userRequest.getDirection() == State.DOWN){
            for (Elevator lift : elevators){
                if(lift.GetState() == State.DOWN && lift.GetFloor() > userRequest.getCurrentFloor()){
                    lift.getTopToBottom().offer(userRequest.getCurrentFloor());
                    return true;
                }
            }
        }
        else if(userRequest.getDirection() == State.UP){
            for (Elevator lift : elevators){
                if(lift.GetState() == State.UP && lift.GetFloor() < userRequest.getCurrentFloor()){
                    lift.getBottomToTop().offer(userRequest.getCurrentFloor());
                    return true;
                }
            }
        }
        return false;
    }

    // check for the IDLE lift
    private boolean checkIdle(List<Elevator> elevators, UserRequest userRequest){
        for (Elevator lift : elevators){
            if(lift.GetState() == State.IDLE){
                if(userRequest.getDirection() == State.DOWN){
                    lift.getTopToBottom().offer(userRequest.getCurrentFloor());
                    return true;
                }
                else{
                    lift.getBottomToTop().offer(userRequest.getCurrentFloor());
                    return true;
                }
            }
        }
        return false;
    }
}
