package Bai3;

public class Motorcycles extends Vehicles {
    private int capacity;

    public Motorcycles (String vehicleNumber, String manufacturer, int yearOfManufacturer, String color, String owner, int capacity) {
        super(vehicleNumber, manufacturer, yearOfManufacturer, color, owner);
        this.capacity = capacity;
    }

    public String toString() {
        return "Motocycle: " + getVehicleNumber() + ", " + getManufacturer() + ", " + getYearOfManufacturer() + ", " + getColor() + ", " + getOwnerID();
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String getType() {
        return "Motorcycle";
    }
}