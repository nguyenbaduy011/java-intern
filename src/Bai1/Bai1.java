package Bai1;

public class Bai1 {
    public static void main(String[] args) {
        Shape s = new Shape(10, 11);
        Circle c = new Circle(3);
        Rectangle r = new Rectangle(4, 5);

        //thông tin shape
        s.print();
        System.out.println();

        //thông tin hình tròn
        c.print();
        System.out.println();

        //thông tin hình chữ nhật
        r.print();
        System.out.println();

    }
}
