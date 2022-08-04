package Class.Factory;

import Class.Branch.FastFoodBranch;
import Class.Branch.HamburgerBranch;
import Class.Menu.AbstractMenu;
import Interface.FastFoodBranchAbstractFactory;

public class HamburgerBranchFactory implements FastFoodBranchAbstractFactory {

    private int localCapacity;
    private boolean autoPickUpOption;
    private String address;
    private boolean parkingLot;
    private boolean delivery;

    private AbstractMenu menu;

    public HamburgerBranchFactory(int localCapacity, boolean autoPickUpOption, String address,
                                  boolean parkingLot, boolean delivery, AbstractMenu menu) {
        this.localCapacity = localCapacity;
        this.autoPickUpOption = autoPickUpOption;
        this.address = address;
        this.parkingLot = parkingLot;
        this.delivery = delivery;
        this.menu = menu;
    }

    @Override
    public FastFoodBranch createNewBranch() {
        return new HamburgerBranch(localCapacity, autoPickUpOption, address, parkingLot, delivery, menu);
    }
}
