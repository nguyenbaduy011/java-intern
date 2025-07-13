package Bai3;

import java.util.*;

public class ManageSystem{
    private ArrayList<Vehicles> list;
    private ArrayList<Owners> ownerList;

    public ManageSystem(ArrayList<Vehicles> list, ArrayList<Owners> ownerList) {
        this.list = list;
        this.ownerList = ownerList;
    }

    public ManageSystem() {
        this.list = new ArrayList<>();
        this.ownerList = new ArrayList<>();
    }

    public void addOwner() {
        this.ownerList.add(new Owners("123456789012", "John Doe", "john.doe@example.com"));
        this.ownerList.add(new Owners("987654321098", "Jane Smith", "jane.smith@domain.com"));
        this.ownerList.add(new Owners("111222333444", "Mary Jane", "mary.jane@domain.com"));
        this.ownerList.add(new Owners("555666777888", "Bob Wilson", "bob.wilson@domain.com"));
        this.ownerList.add(new Owners("999888777666", "Alice Brown", "alice.brown@domain.com"));
        this.ownerList.add(new Owners("444555666777", "Tom Green", "tom.green@domain.com"));
        this.ownerList.add(new Owners("222333444555", "Emma White", "emma.white@domain.com"));
        this.ownerList.add(new Owners("777888999000", "David Lee", "david.lee@domain.com"));
        this.ownerList.add(new Owners("333444555666", "Sarah Taylor", "sarah.taylor@domain.com"));
        this.ownerList.add(new Owners("666777888999", "Michael Clark", "michael.clark@domain.com"));
    }

    public void printOwner() {
        for (Owners owner : this.ownerList) {
            System.out.println(owner);
        }
    }
    public void addVehicle() {
        this.list.add(new Cars("AB123", "Toyota", 2020, "Red", this.ownerList.get(0).getId(), 5, "Petrol"));
        this.list.add(new Trucks("XY789", "Honda", 2019, "Blue", this.ownerList.get(1).getId(), 10));
        this.list.add(new Motorcycles("CD456", "Yamaha", 2021, "Black", this.ownerList.get(2).getId(), 150));
        this.list.add(new Cars("EF678", "Suzuki", 2022, "White", this.ownerList.get(3).getId(), 7, "Diesel"));
        this.list.add(new Trucks("GH901", "Toyota", 2018, "Green", this.ownerList.get(4).getId(), 15));
        this.list.add(new Motorcycles("IJ234", "Honda", 2023, "Silver", this.ownerList.get(5).getId(), 200));
        this.list.add(new Cars("KL567", "Yamaha", 2017, "Yellow", this.ownerList.get(6).getId(), 4, "Petrol"));
        this.list.add(new Trucks("MN890", "Suzuki", 2020, "Gray", this.ownerList.get(7).getId(), 8));
        this.list.add(new Motorcycles("OP123", "Toyota", 2016, "Purple", this.ownerList.get(8).getId(), 300));
        this.list.add(new Cars("QR456", "Honda", 2024, "Orange", this.ownerList.get(9).getId(), 5, "Hybrid"));
    }

    public void printVehicle() {
        for (Vehicles vehicle : list) {
            System.out.println(vehicle);
        }
    }

    public Vehicles searchByVehicleNumber(String vehicleNumber) {
        for (Vehicles vehicle : list) {
            if (vehicle.getVehicleNumber().equals(vehicleNumber))
                return vehicle;
        }
        return null;
    }

    public Vehicles searchByOwnerID(String ownerID) {
        for (Vehicles vehicle : list) {
            if (vehicle.getOwnerID().equals(ownerID))
                return vehicle;
        }
        return null;
    }

    public void deleteByManufacturer(String manufacturer) {
        ArrayList<Vehicles> vehiclesToRemove = new ArrayList<>();

        for (Vehicles vehicle : this.list) {
            if (vehicle.getManufacturer().equals(manufacturer)) {
                vehiclesToRemove.add(vehicle);
            }
        }

        //xoá xe
        for (Vehicles vehicle : vehiclesToRemove) {
            if (this.list.contains(vehicle)) {
                this.list.remove(vehicle);
            }
        }

    }

    public ArrayList<String> getTopManufacturers() {
        ArrayList<String> topManufacturers = new ArrayList<>();

        HashMap<String, Integer> counts = new HashMap<>();
        for (Vehicles vehicle : list) {
            String manufacturer = vehicle.getManufacturer();
            counts.put(manufacturer, counts.getOrDefault(manufacturer, 0) + 1);
        }

        int maxCount = 0;
        for (var entry : counts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                topManufacturers.clear();
                topManufacturers.add(entry.getKey());
            } else if (entry.getValue() == maxCount) {
                if (!topManufacturers.contains(entry.getKey())) {
                    topManufacturers.add(entry.getKey());
                }
            }
        }

        return topManufacturers;
    }

    public ArrayList<Map.Entry<String, Integer>> getVehicleTypesSortedByCount() {
        HashMap<String, Integer> counts = new HashMap<>();
        for (Vehicles vehicle : list) {
            String type = vehicle.getType();
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }

        ArrayList<Map.Entry<String, Integer>> sortedTypes = new ArrayList<>(counts.entrySet());
        sortedTypes.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        return sortedTypes;
    }

    public ArrayList<Map.Entry<String, Integer>> getVehicleTypesByCount() {
        HashMap<String, Integer> counts = new HashMap<>();
        for (Vehicles vehicle : list) {
            String type = vehicle.getType();
            counts.put(type, counts.getOrDefault(type, 0) + 1);
        }

        ArrayList<Map.Entry<String, Integer>> result = new ArrayList<>(counts.entrySet());
        return result;
    }
}