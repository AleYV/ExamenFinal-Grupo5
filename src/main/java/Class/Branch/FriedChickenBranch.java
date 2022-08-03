package Class.Branch;

import Class.Menu.AbstractMenu;
import Interface.Delivery;
import Interface.ParkingLot;

public class FriedChickenBranch extends FastFoodBranch {

    public FriedChickenBranch(int localCapacity, boolean autoPickUpOption,
                              String address, ParkingLot parkingLot, Delivery delivery, AbstractMenu menu) {
        super(localCapacity, autoPickUpOption, address, parkingLot, delivery, menu);
    }
}
