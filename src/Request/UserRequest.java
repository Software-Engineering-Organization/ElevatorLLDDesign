package Request;

import Entities.State;

public class UserRequest {
    int currentFloor;
    State direction;

    UserRequest(int currFloor, State dir){
        currentFloor = currFloor;
        direction = dir;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public State getDirection() {
        return direction;
    }

    public void setDirection(State direction) {
        this.direction = direction;
    }
}
