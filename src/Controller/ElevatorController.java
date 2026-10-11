package Controller;

import Entities.Elevator;
import Interfaces.ElevatorRequestStratergy;

import java.util.List;

public class ElevatorController {
    ElevatorRequestStratergy elevatorRequestStratergy;
    List<Elevator> elevators;

    ElevatorController(ElevatorRequestStratergy elevatorRequestStratergy, List<Elevator> elevators){
        this.elevatorRequestStratergy = elevatorRequestStratergy;
        this.elevators = elevators;
    }
}
