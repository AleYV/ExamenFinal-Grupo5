package Interface;

public interface ParkingLot {

    int getParkingCapacity();
    boolean addCar();
    boolean removeCar();

    boolean isFull();
}
