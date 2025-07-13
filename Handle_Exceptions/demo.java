// Full demo: handling exceptions in Java
public class ExceptionDemo {
    public static void main(String[] args) {
        // 1. Basic try-catch
        try {
            int a = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }

        // 2. Multiple catch blocks
        try {
            int[] arr = new int[3];
            arr[5] = 100;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Exception: " + e.getMessage());
        }

        // 3. finally block
        try {
            String s = null;
            System.out.println(s.length());
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
        } finally {
            System.out.println("finally block always runs");
        }

        // 4. throw keyword
        try {
            checkAge(15);
        } catch (IllegalArgumentException e) {
            System.out.println("Throw example: " + e.getMessage());
        }

        // 5. throws keyword + custom exception
        try {
            validateName("123");
        } catch (InvalidNameException e) {
            System.out.println("Custom exception: " + e.getMessage());
        }
    }

    // throw demo
    static void checkAge(int age) {
        if (age < 18)
            throw new IllegalArgumentException("You must be 18 or older.");
    }

    // throws demo with custom exception
    static void validateName(String name) throws InvalidNameException {
        if (!name.matches("[a-zA-Z]+")) {
            throw new InvalidNameException("Name must contain only letters.");
        }
        System.out.println("Valid name: " + name);
    }
}

// 6. Custom Exception Class
class InvalidNameException extends Exception {
    public InvalidNameException(String message) {
        super(message);
    }
}
