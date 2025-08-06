package Bai2;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class Crockery extends Goods {
    private String manufacturerInfo; //thông tin sản xuất
    private LocalDate arrivalDate; //ngày nhập hàng

    public Crockery(String productId, String productName, int quantity, double price, String description, String manufacturerInfo, LocalDate arrivalDate) {
        super(productId, productName, quantity, price);
        this.manufacturerInfo = manufacturerInfo;
        this.arrivalDate = arrivalDate;
    }

    public Crockery() {
    }

    public String getManufacturerInfo() {
        return manufacturerInfo;
    }

    public void setManufacturerInfo(String manufacturerInfo) {
        this.manufacturerInfo = manufacturerInfo;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    @Override
    public void measureConsumption(){
        super.measureConsumption();
        LocalDate currentDate = LocalDate.now();

        if(getQuantity() > 50 && Period.between(arrivalDate, currentDate).getDays() > 10) {
            System.out.println("Crockery Goods: low sale");
        }
    }
}
