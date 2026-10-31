import Entities.Elevator;
import Entities.InternalButton;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        System.out.println("Elevator LLD design");

        Elevator elevator1 = new Elevator(1, new InternalButton());
        Elevator elevator2 = new Elevator(2, new InternalButton());

        elevator1.PlaceInternalUserRequest(2);
        elevator2.PlaceInternalUserRequest(4);

        Thread t1 = new Thread(elevator1);
        Thread t2 = new Thread(elevator2);

        t1.start();
        t2.start();
    }
}