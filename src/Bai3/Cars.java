package Bai3;

public class Cars extends Vehicles {
    private int numberOfSeats;
    private String engineType;

    public Cars (String vehicleNumber, String manufacturer, int yearOfManufacturer, String color, String owner, int numberOfSeats, String engineType) {
        super(vehicleNumber, manufacturer, yearOfManufacturer, color, owner);
        this.numberOfSeats = numberOfSeats;
        this.engineType = engineType;
    }

    public String toString() {
        return "Car: " + getVehicleNumber() + ", " + getManufacturer() + ", " + getYearOfManufacturer() + ", " + getColor() + ", " + getOwnerID();
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    @Override
    public String getType() {
        return "Car";
    }
}
