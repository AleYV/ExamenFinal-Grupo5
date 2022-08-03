package Class.Factory;

import Interface.Delivery;
import Interface.ParkingLot;

public abstract class FastFoodChainFactory {

    protected int localCapacity;
    protected boolean pickUpOption, autoPickUpOption;
    protected String address;
    protected ParkingLot parkingLot;
    protected Delivery delivery;

    public String getAddress(){ return address; }
    public abstract FastFoodChainFactory setAddress(String address);
    public abstract FastFoodChainFactory withCapacity(int localCapacity);
    public abstract FastFoodChainFactory withDeliveryOption(int personal);
    public abstract FastFoodChainFactory withPickUpOption();
    public abstract FastFoodChainFactory withAutoPickUpOption();
    public abstract FastFoodChainFactory withParkingLot(int parkingCapacity);
}
