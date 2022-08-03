package Class.ParkingLot;

import Interface.ParkingLot;

public class FriedChickenParkingLot implements ParkingLot {

    int parkingCapacity;
    int nCars = 0;

    public FriedChickenParkingLot(int parkingCapacity) {
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
}
