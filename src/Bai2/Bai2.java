package Bai2;

import java.time.LocalDate;
import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        DSHH<Goods> store = new DSHH<Goods>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose goods type to add: ");
        System.out.println("1. Food");
        System.out.println("2. Electronic");
        System.out.println("3. Crockery");
        System.out.print("Choose goods type to add: ");
        String choice = sc.nextLine();
        String goodsTypeName = switch (choice) {
            case "1" -> "Food";
            case "2" -> "Electronic";
            case "3" -> "Crockery";
            default -> "Unknown/Invalid Type";
        };
        System.out.println("Goods type: " + goodsTypeName);

        switch (choice) {
            case ("1"):
                Food newFood = new Food();
                System.out.println("Enter Goods id: ");
                newFood.setProductId(sc.nextLine());
                System.out.println("Enter Goods name: ");
                newFood.setProductName(sc.nextLine());
                System.out.println("Enter Goods price: ");
                newFood.setPrice(sc.nextDouble());
                sc.nextLine();
                System.out.println("Enter Goods quantity: ");
                newFood.setQuantity(sc.nextInt());
                sc.nextLine();
                System.out.println("Enter Goods manufacturing date(YYYY-MM-DD): ");
                newFood.setManufacturingDate(LocalDate.parse(sc.nextLine()));
                System.out.println("Enter Goods expiration date(YYYY-MM-DD): ");
                newFood.setExpirationDate(LocalDate.parse(sc.nextLine()));

                store.setGoods(newFood);
                break;

            case ("2"):
                Electronic newElectronic = new Electronic();
                System.out.println("Enter Goods id: ");
                newElectronic.setProductId(sc.nextLine());
                System.out.println("Enter Goods name: ");
                newElectronic.setProductName(sc.nextLine());
                System.out.println("Enter Goods price: ");
                newElectronic.setPrice(sc.nextDouble());
                sc.nextLine();
                System.out.println("Enter Goods quantity: ");
                newElectronic.setQuantity(sc.nextInt());
                sc.nextLine();
                System.out.println("Enter Goods warranty months: ");
                newElectronic.setWarrantyMonths(sc.nextInt());
                sc.nextLine();
                System.out.println("Enter Goods powerCapacity: ");
                newElectronic.setPowerCapacity(sc.nextInt());
                sc.nextLine();

                store.setGoods(newElectronic);
                break;

            case ("3"):
                Crockery newCrockery = new Crockery();
                System.out.println("Enter Goods id: ");
                newCrockery.setProductId(sc.nextLine());
                System.out.println("Enter Goods name: ");
                newCrockery.setProductName(sc.nextLine());
                System.out.println("Enter Goods price: ");
                newCrockery.setPrice(sc.nextDouble());
                sc.nextLine();
                System.out.println("Enter Goods quantity: ");
                newCrockery.setQuantity(sc.nextInt());
                sc.nextLine();
                System.out.println("Enter Goods manufacturer information: ");
                newCrockery.setManufacturerInfo(sc.nextLine());
                System.out.println("Enter Goods arrival date(YYYY-MM-DD): ");
                newCrockery.setArrivalDate(LocalDate.parse(sc.nextLine()));

                store.setGoods(newCrockery);
                break;

        }
    }
}
