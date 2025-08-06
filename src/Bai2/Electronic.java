package Bai2;

import java.time.LocalDate;

public class Electronic extends Goods {
    private int warrantyMonths; //số tháng bảo hành
    private int powerCapacity; //công suất

    public Electronic(String productId, String productName, int quantity, double price, String description, int warrantyMonths, int powerCapacity) {
        super(productId, productName, quantity, price);
        this.warrantyMonths = warrantyMonths;
        this.powerCapacity = powerCapacity;
    }

    public Electronic(){}

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    public int getPowerCapacity() {
        return powerCapacity;
    }

    public void setPowerCapacity(int powerCapacity) {
        this.powerCapacity = powerCapacity;
    }

    @Override
    public void measureConsumption(){
        super.measureConsumption();
        if(getQuantity() < 3){
            System.out.println("Electronic Goods: sold");
        }
    }
}
