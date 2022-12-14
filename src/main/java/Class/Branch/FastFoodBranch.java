package Class.Branch;

import Class.Menu.AbstractMenu;

public abstract class FastFoodBranch {

    protected int localCapacity;
    protected boolean autoPickUpOption;
    protected String address;
    protected boolean parkingLot;
    protected boolean delivery;
    protected AbstractMenu menu;

    public FastFoodBranch(int localCapacity, boolean autoPickUpOption,
                          String address, boolean parkingLot, boolean delivery, AbstractMenu menu) {
        this.localCapacity = localCapacity;
        this.autoPickUpOption = autoPickUpOption;
        this.address = address;
        this.parkingLot = parkingLot;
        this.delivery = delivery;
        this.menu = menu;
    }

    public String getAddress(){ return address; }

    public int getLocalCapacity(){ return localCapacity; }

    public boolean hasAutoPickUpOption(){ return autoPickUpOption; }

    public boolean hasDelivery(){ return delivery; }

    public boolean hasParkingLot(){ return parkingLot; }

    public AbstractMenu getMenu(){ return menu; }

}
