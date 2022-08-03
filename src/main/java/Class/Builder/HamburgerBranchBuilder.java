package Class.Builder;

import Class.Factory.FastFoodChainFactory;
import Class.ParkingLot.HamburgerParkingLot;
import Class.Delivery.HamburgerDelivery;

public class HamburgerBranchBuilder extends FastFoodChainFactory {

    public HamburgerBranchBuilder builder(){
        return new HamburgerBranchBuilder();
    }

    @Override
    public FastFoodChainFactory setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public FastFoodChainFactory withCapacity(int localCapacity) {
        this.localCapacity = localCapacity;
        return this;
    }

    @Override
    public FastFoodChainFactory withDeliveryOption(int personal) {
        this.delivery = new HamburgerDelivery(personal);
        return this;
    }

    @Override
    public FastFoodChainFactory withPickUpOption() {
        pickUpOption = true;
        return this;
    }

    @Override
    public FastFoodChainFactory withAutoPickUpOption() {
        autoPickUpOption = true;
        return this;
    }

    @Override
    public FastFoodChainFactory withParkingLot(int parkingCapacity) {
        this.parkingLot = new HamburgerParkingLot(parkingCapacity);
        return this;
    }
}
