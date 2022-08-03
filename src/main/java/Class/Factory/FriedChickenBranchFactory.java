package Class.Factory;

import Class.Branch.FastFoodBranch;
import Class.Branch.FriedChickenBranch;
import Class.Menu.AbstractMenu;
import Interface.Delivery;
import Interface.FastFoodBranchAbstractFactory;
import Interface.ParkingLot;

public class FriedChickenBranchFactory implements FastFoodBranchAbstractFactory {

    private int localCapacity;
    private boolean autoPickUpOption;
    private String address;
    private ParkingLot parkingLot;
    private Delivery delivery;

    private AbstractMenu menu;

    public FriedChickenBranchFactory(int localCapacity, boolean autoPickUpOption,
                                     String address, ParkingLot parkingLot, Delivery delivery, AbstractMenu menu) {
        this.localCapacity = localCapacity;
        this.autoPickUpOption = autoPickUpOption;
        this.address = address;
        this.parkingLot = parkingLot;
        this.delivery = delivery;
        this.menu = menu;
    }

    @Override
    public FastFoodBranch createNewBranch() {
        return new FriedChickenBranch(localCapacity, autoPickUpOption, address, parkingLot, delivery, menu);
    }
}
