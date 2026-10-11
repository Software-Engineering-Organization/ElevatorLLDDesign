package Entities;

public class Elevator {
    int elevatorNumber;
    InternalButton internalButton;
    State state;

    Elevator(int elevatorNumber, InternalButton internalButton){
        this.elevatorNumber = elevatorNumber;
        this.internalButton = internalButton;
        state = State.IDLE;
    }
}
