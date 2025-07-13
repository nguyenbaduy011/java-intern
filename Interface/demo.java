// Define an interface
interface Shape {
    void draw();            // Method to draw the shape
    double getArea();       // Method to calculate area
}

// Implementing the interface in Circle
class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.println("Drawing a circle");
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }
}

// Implementing the interface in Square
class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public void draw() {
        System.out.println("Drawing a square");
    }

    public double getArea() {
        return side * side;
    }
}

// Implementing the interface in Rectangle
class Rectangle implements Shape {
    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public void draw() {
        System.out.println("Drawing a rectangle");
    }

    public double getArea() {
        return width * height;
    }
}

// Implementing the interface in Pediment (Triangle)
class Pediment implements Shape {
    private double base, height;

    public Pediment(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public void draw() {
        System.out.println("Drawing a pediment (triangle)");
    }

    public double getArea() {
        return 0.5 * base * height;
    }
}

// Main class to test
public class InterfaceDemo {
    public static void main(String[] args) {
        Shape[] shapes = {
            new Circle(5),
            new Square(4),
            new Rectangle(6, 3),
            new Pediment(5, 4)
        };

        for (Shape shape : shapes) {
            shape.draw();
            System.out.println("Area: " + shape.getArea());
            System.out.println();
        }
    }
}
