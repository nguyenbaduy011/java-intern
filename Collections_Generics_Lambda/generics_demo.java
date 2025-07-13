import java.util.*;

// 1. Generic Class
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

// 2. Generic Method
class Utility {
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

// 3. Generic Interface
interface Pair<K, V> {
    K getKey();
    V getValue();
}

class OrderedPair<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

// 4. Bounded Type Parameter
class MathUtils {
    public static <T extends Number> double square(T number) {
        return number.doubleValue() * number.doubleValue();
    }
}

// 5. Main Class to Run All
public class GenericsDemo {
    public static void main(String[] args) {
        // Generic Class
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello Generics!");
        System.out.println("Box contains: " + stringBox.get());

        // Generic Method
        Integer[] intArray = {1, 2, 3};
        String[] strArray = {"A", "B", "C"};
        System.out.print("Integer Array: ");
        Utility.printArray(intArray);
        System.out.print("String Array: ");
        Utility.printArray(strArray);

        // Generic Interface
        Pair<Integer, String> pair = new OrderedPair<>(101, "Alice");
        System.out.println("Pair: [" + pair.getKey() + ", " + pair.getValue() + "]");

        // Bounded Type
        System.out.println("Square of 5: " + MathUtils.square(5));
        System.out.println("Square of 3.14: " + MathUtils.square(3.14));
    }
}
