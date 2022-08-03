package Class.Branch;

import Class.Menu.AbstractMenu;
import Interface.Delivery;
import Interface.ParkingLot;

public abstract class FastFoodBranch {

    protected int localCapacity;
    protected boolean autoPickUpOption;
    protected String address;
    protected ParkingLot parkingLot;
    protected Delivery delivery;
    protected AbstractMenu menu;

    public FastFoodBranch(int localCapacity, boolean autoPickUpOption,
                          String address, ParkingLot parkingLot, Delivery delivery, AbstractMenu menu) {
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

    public Delivery getDelivery(){ return delivery; }

    public ParkingLot getParkingLot(){ return parkingLot; }

    public AbstractMenu getMenu(){ return menu; }

    @Override
    public String toString(){
        String sString = "My address is: " + address + " with " + localCapacity + " of capacity"
                + "\ncan autoPickUp?: " + autoPickUpOption;
        if(delivery != null) sString += "\nwith Delivery";
        else sString += "\ndont have Delivery";
        if(parkingLot != null) sString += "\nwith Parking lot";
        else sString += "\ndont have Parking lot";

        sString += "\n";
        return sString;
    }

}
