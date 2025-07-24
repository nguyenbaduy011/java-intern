package Bai3;

public class Trucks extends Vehicles {
    private int tonnage;

    public Trucks (String vehicleNumber, String manufacturer, int yearOfManufacturer, String color, String owner, int tonnage) {
        super(vehicleNumber, manufacturer, yearOfManufacturer, color, owner);
        this.tonnage = tonnage;
    }

    public String toString() {
        return "Truck: " + getVehicleNumber() + ", " + getManufacturer() + ", " + getYearOfManufacturer() + ", " + getColor() + ", " + getOwnerID();
    }

    public int getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public String getType() {
        return "Truck";
    }
}