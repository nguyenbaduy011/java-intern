import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {
        // Create two collections
        Collection<String> fruits = new ArrayList<>();
        Collection<String> moreFruits = Arrays.asList("banana", "orange");

        // 1. add(Object element)
        fruits.add("apple");
        fruits.add("banana");
        System.out.println("After add(): " + fruits);

        // 2. addAll(Collection c)
        fruits.addAll(moreFruits);
        System.out.println("After addAll(): " + fruits);

        // 3. remove(Object element)
        fruits.remove("banana");
        System.out.println("After remove(): " + fruits);

        // 4. removeAll(Collection c)
        fruits.removeAll(Arrays.asList("orange"));
        System.out.println("After removeAll(): " + fruits);

        // 5. retainAll(Collection c)
        fruits.add("grape");
        fruits.add("kiwi");
        fruits.retainAll(Arrays.asList("apple", "grape")); // keep only these
        System.out.println("After retainAll(): " + fruits);

        // 6. contains(Object element)
        System.out.println("Contains 'apple'? " + fruits.contains("apple"));
        System.out.println("Contains 'kiwi'? " + fruits.contains("kiwi"));

        // 7. containsAll(Collection c)
        System.out.println("Contains all [apple, grape]? " + fruits.containsAll(Arrays.asList("apple", "grape")));

        // 8. clear()
        fruits.clear();
        System.out.println("After clear(): " + fruits);

        // 9. size()
        System.out.println("Size: " + fruits.size());
    }
}
