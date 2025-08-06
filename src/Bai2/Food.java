package Bai2;

import java.time.LocalDate;


public class Food extends Goods {
    private LocalDate manufacturingDate; //ngày sản xuất
    private LocalDate expirationDate; //ngày hết hạn

    public Food(String productId, String productName, int quantity, double price, String description, LocalDate manufactoringDate, LocalDate expirationDate) {
        super(productId, productName, quantity, price);
        this.manufacturingDate = manufactoringDate;
        this.expirationDate = expirationDate;
        if (expirationDate.isBefore(manufactoringDate)) {
            throw new IllegalArgumentException("The expiration date cannot be before the manufactoring date.");
        }
    }

    public Food() {
    }

    public LocalDate getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(LocalDate manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public void measureConsumption(){
        super.measureConsumption();
        LocalDate currentDate = LocalDate.now();

        if(getQuantity() > 0 && getExpirationDate().isAfter(currentDate)){
            System.out.println("Food Goods: : hard to sell.");
        }
    }
}
