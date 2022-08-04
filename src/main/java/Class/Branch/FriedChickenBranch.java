package Class.Branch;

import Class.Menu.AbstractMenu;

public class FriedChickenBranch extends FastFoodBranch {

    public FriedChickenBranch(int localCapacity, boolean autoPickUpOption,
                              String address, boolean parkingLot, boolean delivery, AbstractMenu menu) {
        super(localCapacity, autoPickUpOption, address, parkingLot, delivery, menu);
    }
}
