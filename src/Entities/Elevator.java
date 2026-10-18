package Entities;

public class Elevator {
    int elevatorNumber;
    InternalButton internalButton;
    State state;
    int FloorNumber;

    Elevator(int elevatorNumber, InternalButton internalButton){
        this.elevatorNumber = elevatorNumber;
        this.internalButton = internalButton;
        state = State.IDLE;
    }

    public void SetState(State state){
        this.state = state;
    }

    public State GetState(){
        return state;
    }

    public void SetFloor(int floorNo){
        FloorNumber = floorNo;
    }

    public int GetFloor(){
        return FloorNumber;
    }
}
