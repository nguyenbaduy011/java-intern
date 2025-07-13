// Superclass
class Geometry {
    public void display() {
        System.out.println("This is a geometric shape.");
    }
}

// Subclass: Circle
class Circle extends Geometry {
    @Override
    public void display() {
        System.out.println("This is a circle.");
    }
}

// Subclass: Square
class Square extends Geometry {
    @Override
    public void display() {
        System.out.println("This is a square.");
    }
}

// Subclass: Rectangle
class Rectangle extends Geometry {
    @Override
    public void display() {
        System.out.println("This is a rectangle.");
    }
}

// Subclass: Pediment (Triangle-like)
class Pediment extends Geometry {
    @Override
    public void display() {
        System.out.println("This is a pediment (triangle).");
    }
}

// Main class to test inheritance
public class GeometryDemo {
    public static void main(String[] args) {
        Geometry[] shapes = {
            new Circle(),
            new Square(),
            new Pediment(),
            new Rectangle()
        };

        for (Geometry shape : shapes) {
            shape.display();  // Polymorphism in action
        }
    }
}
