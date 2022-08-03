package Class.ParkingLot;

import Interface.ParkingLot;

public class PizzaParkingLot implements ParkingLot {

    int parkingCapacity;
    int nCars = 0;

    public PizzaParkingLot(int parkingCapacity) {
        this.parkingCapacity = parkingCapacity;
    }

    @Override
    public int getParkingCapacity() {
        return parkingCapacity;
    }

    @Override
    public boolean addCar() {
        if(nCars < parkingCapacity) {
            nCars++;
            return  true;
        }
        return false;
    }

    @Override
    public boolean removeCar() {
        if(nCars > 0) {
            nCars--;
            return  true;
        }
        return false;
    }

    @Override
    public boolean isFull(){
        return nCars == parkingCapacity;
    }

    @Override
    public String toString() {
        return "with capacity: " + parkingCapacity;
    }
}
