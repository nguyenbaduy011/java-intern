package Bai1;

public class Rectangle extends Shape {
    public Rectangle(double width, double height) {
        super(width, height);
    }

    public Rectangle() {
    }

    public double getArea() {
        return getWidth() * getHeight();
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
    }

    public double getPerimeter() {
        return 2 * getWidth() + 2 * getHeight();
    }
}
