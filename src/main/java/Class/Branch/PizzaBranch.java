package Class.Branch;

import Class.Menu.AbstractMenu;
import Interface.Delivery;
import Interface.ParkingLot;

public class PizzaBranch extends FastFoodBranch {

    public PizzaBranch(int localCapacity, boolean autoPickUpOption,
                       String address, ParkingLot parkingLot, Delivery delivery, AbstractMenu menu) {
        super(localCapacity, autoPickUpOption, address, parkingLot, delivery, menu);
    }
}
