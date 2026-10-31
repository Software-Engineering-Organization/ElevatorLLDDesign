package Entities;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

public class Elevator implements Runnable {
    int elevatorNumber;
    InternalButton internalButton;
    State state;
    int FloorNumber;

    // Thread Safe PriorityQueues for floors
    PriorityBlockingQueue<Integer> bottomToTop;
    PriorityBlockingQueue<Integer> topToBottom;

    public Elevator(int elevatorNumber, InternalButton internalButton){
        this.elevatorNumber = elevatorNumber;
        this.internalButton = internalButton;
        state = State.IDLE;

        // initialise the Queue.
        bottomToTop = new PriorityBlockingQueue<>();
        topToBottom = new PriorityBlockingQueue<>(100, Comparator.reverseOrder());

    }

    @Override
    public void run() {

        while (true) {

            System.out.println(
                    "Elevator " + elevatorNumber +
                            " is alive at floor " + FloorNumber
            );
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }

    public void PlaceInternalUserRequest(int floorNumber){
        System.out.println("Placing the Internal Request...");
        internalButton.placeInternalButtonRequest(this, floorNumber);

        System.out.println("Internal Request placed successfully...");
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
