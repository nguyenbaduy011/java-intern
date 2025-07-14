import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;

public class StringArrayDateDemo {
    public static void main(String[] args) {
        // === STRING OPERATIONS ===
        // 1. Create Strings
        String str1 = "Hello";
        String str2 = "World";

        // 2. Join Strings
        String joined = String.join(" ", str1, str2);
        System.out.println("Joined: " + joined);  // Hello World

        // 3. Append Strings
        String appended = str1 + " Java!";
        System.out.println("Appended: " + appended);  // Hello Java!

        // 4. Compare Strings
        String a = "abc";
        String b = "ABC";
        System.out.println("Equal ignoring case? " + a.equalsIgnoreCase(b));  // true
        System.out.println("Lexical compare: " + a.compareTo(b)); // > 0 if a > b

        // === STRING ARRAY OPERATIONS ===
        // 5. Create Array
        String[] arr1 = {"apple", "banana", "cherry"};
        String[] arr2 = {"apple", "banana", "cherry"};
        String[] arr3 = {"apple", "banana", "grape"};

        // 6. Compare Arrays
        System.out.println("arr1 == arr2? " + Arrays.equals(arr1, arr2));  // true
        System.out.println("arr1 == arr3? " + Arrays.equals(arr1, arr3));  // false

        // === DATE OPERATIONS ===
        // 7. Create Current Date
        Date now = new Date();
        System.out.println("Current Date: " + now);

        // 8. Format Date
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Formatted Date: " + formatter.format(now));
    }
}
