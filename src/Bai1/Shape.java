package Bai1;

public class Shape {
    private double width;
    private double height;

    public Shape() {}

    public Shape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void print(){
        System.out.println(this.getClass().getSimpleName());
        System.out.println("Width: " + width);
        System.out.println("Height: " + height);
    }
}

