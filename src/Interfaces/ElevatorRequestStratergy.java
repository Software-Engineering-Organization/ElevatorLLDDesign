package Interfaces;

import Entities.Elevator;
import Request.UserRequest;

import java.util.List;

public interface ElevatorRequestStratergy {
    public boolean checkElevatorAvailability(List<Elevator> elevatorList, UserRequest userRequest);
}
