package Bai3;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Vehicles {
    private String vehicleNumber;
    private String manufacturer;
    private int yearOfManufacturer;
    private String color;
    private String ownerID;
    private static final ArrayList<String> vehicleNumbers = new ArrayList<>();

    public Vehicles(String vehicleNumber, String manufacturer, int yearOfManufacturer, String color, String ownerID) {
        if (vehicleNumber.length() != 5) {
            throw new IllegalArgumentException("Vehicle number " + vehicleNumber + " must have exactly 5 characters.\nPlease check the data");
        }
        if (vehicleNumbers.contains(vehicleNumber)) {
            throw new IllegalArgumentException("Vehicle number " + vehicleNumber + " has been used.\nPlease check the data");
        }
        this.vehicleNumber = vehicleNumber;

        if (manufacturer.equals("Honda") || manufacturer.equals("Yamaha") || manufacturer.equals("Suzuki") || manufacturer.equals("Toyota")) {
            this.manufacturer = manufacturer;
        } else {
            throw new IllegalArgumentException("No + " + manufacturer + " manufacturer found.\nManufacturer must be one of: Honda, Yamaha, Toyota, Suzuki");
        }

        if (yearOfManufacturer > 2000 && yearOfManufacturer < LocalDate.now().getYear()) {
            this.yearOfManufacturer = yearOfManufacturer;
        }
        this.color = color;
        this.ownerID = ownerID;
        vehicleNumbers.add(vehicleNumber);
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getYearOfManufacturer() {
        return yearOfManufacturer;
    }

    public String getColor() {
        return color;
    }

    public String getOwnerID() {
        return ownerID;
    }

    public abstract String getType();
}
