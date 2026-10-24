package Entities;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class Elevator {
    int elevatorNumber;
    InternalButton internalButton;
    State state;
    int FloorNumber;

    // Thread Safe PriorityQueues for floors
    PriorityBlockingQueue<Integer> bottomToTop;
    PriorityBlockingQueue<Integer> topToBottom;

    Elevator(int elevatorNumber, InternalButton internalButton){
        this.elevatorNumber = elevatorNumber;
        this.internalButton = internalButton;
        state = State.IDLE;

        // initialise the Queue.
        bottomToTop = new PriorityBlockingQueue<>();
        topToBottom = new PriorityBlockingQueue<>(100, Comparator.reverseOrder());

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

    public PriorityBlockingQueue<Integer> getTopToBottom() {
        return topToBottom;
    }

    public PriorityBlockingQueue<Integer> getBottomToTop() {
        return bottomToTop;
    }
}
