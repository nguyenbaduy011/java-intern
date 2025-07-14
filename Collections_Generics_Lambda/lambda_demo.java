import java.util.*;
import java.util.stream.Collectors;
import javax.swing.*;
import java.awt.event.*;

public class LambdaExpressionDemo {
    public static void main(String[] args) {
        // 1. forEach loop
        List<String> list = Arrays.asList("apple", "banana", "cherry");
        System.out.println("forEach loop:");
        list.forEach(item -> System.out.println(item));

        // 2. With Parameter
        MyPrinter printer = (name) -> System.out.println("Hello " + name);
        printer.print("Lambda");

        // 3. With or without return keyword
        Calculator square = x -> x * x;  // no return keyword needed
        System.out.println("Square of 5: " + square.calculate(5));

        Calculator add = x -> {
            int result = x + 10;
            return result; // return keyword used
        };
        System.out.println("Add 10 to 7: " + add.calculate(7));

        // 4. Multiple Statements
        MyPrinter greet = (name) -> {
            System.out.println("------");
            System.out.println("Welcome, " + name);
            System.out.println("------");
        };
        greet.print("Developer");

        // 5. Creating Thread
        Thread t = new Thread(() -> System.out.println("Thread running via lambda!"));
        t.start();

        // 6. Comparator
        List<String> names = Arrays.asList("Zoe", "Alice", "Bob");
        names.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        System.out.println("Sorted names: " + names);

        // 7. Filter Collection Data
        List<String> filtered = list.stream()
                                    .filter(item -> item.startsWith("b"))
                                    .collect(Collectors.toList());
        System.out.println("Filtered list (start with 'b'): " + filtered);

        // 8. Event Listener (Swing)
        JFrame frame = new JFrame("Lambda Button");
        JButton button = new JButton("Click me");
        button.setBounds(100, 100, 120, 40);

        button.addActionListener(e -> JOptionPane.showMessageDialog(null, "Button clicked!"));

        frame.add(button);
        frame.setSize(300, 250);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Functional interface for printer
    interface MyPrinter {
        void print(String name);
    }

    // Functional interface for calculation
    interface Calculator {
        int calculate(int x);
    }
}
