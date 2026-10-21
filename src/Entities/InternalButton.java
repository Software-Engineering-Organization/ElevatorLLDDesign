package Entities;

public class InternalButton {
    Elevator elevator;
    int internalButtonFloorNumber;

    InternalButton(Elevator elevator, int internalButtonFloorNumber){
        this.elevator = elevator;
        this.internalButtonFloorNumber = internalButtonFloorNumber;
    }

    public void placeInternalButtonRequest(){
        if(elevator.state == State.DOWN){
            if(elevator.GetFloor() < internalButtonFloorNumber){
                elevator.bottomToTop.offer(internalButtonFloorNumber);
            }
            else{
                elevator.topToBottom.offer(internalButtonFloorNumber);
            }
            return;
        }
        else if(elevator.state == State.UP){
            if(elevator.GetFloor() > internalButtonFloorNumber){
                elevator.topToBottom.offer(internalButtonFloorNumber);
            }
            else{
                elevator.bottomToTop.offer(internalButtonFloorNumber);
            }
            return;
        }
        elevator.topToBottom.offer(internalButtonFloorNumber);
    }
}
