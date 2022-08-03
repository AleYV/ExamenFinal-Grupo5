package Class.Builder;

import Class.Factory.FastFoodChainFactory;
import Class.ParkingLot.PizzaParkingLot;
import Class.Delivery.PizzaDelivery;

public class PizzaBranchBuilder extends FastFoodChainFactory {

    public PizzaBranchBuilder builder(){
        return new PizzaBranchBuilder();
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
        this.delivery = new PizzaDelivery(personal);
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
        this.parkingLot = new PizzaParkingLot(parkingCapacity);
        return this;
    }
}
