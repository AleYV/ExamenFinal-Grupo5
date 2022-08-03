package Class.Builder;

import Class.Factory.FastFoodChainFactory;
import Class.ParkingLot.FriedChickenParkingLot;
import Class.Delivery.FriedChickenDelivery;

public class FriedChickenBranchBuilder extends FastFoodChainFactory {

    public FriedChickenBranchBuilder build(){
        return new FriedChickenBranchBuilder();
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
        this.delivery = new FriedChickenDelivery(personal);
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
        parkingLot = new FriedChickenParkingLot(parkingCapacity);
        return this;
    }
}
