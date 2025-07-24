package Bai3;

import java.util.Map;

public class Bai3 {
    public static void main(String[] args) {
        ManageSystem system = new ManageSystem();

        System.out.println("Test 1: Initiate");
        system.addOwner();
        system.addVehicle();
        system.printVehicle();

        System.out.println("\nTest 2: Search by Vehicle Number");
        if (system.searchByVehicleNumber("EF678") != null) {
            System.out.println(system.searchByVehicleNumber("EF678"));
        } else
            System.out.println("Not found");

        System.out.println("\nTest 3: Search by Owner ID");
        if (system.searchByOwnerID("444555666777") != null) {
            System.out.println(system.searchByOwnerID("444555666777"));
        } else
            System.out.println("Not found");

        System.out.println("\nTest 4: Delete by Manufacturer");
        system.deleteByManufacturer("Honda");
        system.printVehicle();

        System.out.println("\nTest 5: Get top Manufacturer");
        if (!system.getTopManufacturers().isEmpty()) {
            for (String manufacturer : system.getTopManufacturers())
                System.out.println(manufacturer);
        } else
            System.out.println("Empty data");

        System.out.println("\nTest 6: Sort type by number of vehicles");
        for (Map.Entry<String, Integer> entry : system.getVehicleTypesSortedByCount()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nTest 7: Statistic of each vehicle type");
        for (Map.Entry<String, Integer> entry : system.getVehicleTypesByCount()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
