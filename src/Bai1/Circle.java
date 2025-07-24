package Bai1;

public class Circle extends Shape {
    private double radius;

    public Circle(double width, double height, double radius) {
        super(width, height);
        this.radius = radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void print() {
        System.out.println(this.getClass().getSimpleName());
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
    }

    public double getCircumference() {
        return 2 * Math.PI * radius;
    }
}
