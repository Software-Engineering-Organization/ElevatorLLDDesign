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
                System.out.println("chose bottomToTop");
                elevator.bottomToTop.offer(internalButtonFloorNumber);
            }
            else{
                System.out.println("chose topToBottom");
                elevator.topToBottom.offer(internalButtonFloorNumber);
            }
            return;
        }
        else if(elevator.state == State.UP){
            if(elevator.GetFloor() > internalButtonFloorNumber){
                System.out.println("chose topToBottom");
                elevator.topToBottom.offer(internalButtonFloorNumber);
            }
            else{
                System.out.println("chose bottomToTop");
                elevator.bottomToTop.offer(internalButtonFloorNumber);
            }
            return;
        }

        // when the elevator is ideal and we choose which PQ to use
        if(elevator.GetFloor() < internalButtonFloorNumber){
            System.out.println("chose topToBottom from the ideal state");
            elevator.topToBottom.offer(internalButtonFloorNumber);
        }
        else{
            System.out.println("chose getBottomToTop from the ideal state");
            elevator.getBottomToTop().offer(internalButtonFloorNumber);
        }
    }
}
