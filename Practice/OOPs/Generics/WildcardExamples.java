package Practice.OOPs.Generics;

import java.util.ArrayList;
import java.util.List;

public class WildcardExamples {

    // Example 1: Unbounded Wildcard ( ? )
    public void unboundedWildcardExample() {
        List<?> list = new ArrayList<>();
        list.add(null); // Only null can be added
        System.out.println("Unbounded Wildcard example executed.");
    }

    // Example 2: Upper Bounded Wildcard ( ? extends Type )
    public void upperBoundedWildcardExample() {
        List<? extends Number> numbers = new ArrayList<Integer>();
        // numbers.add(5); // Error: Cannot add to a list with extends

        numbers.add(null); // You can add null
        System.out.println("Upper Bounded Wildcard example executed.");
    }

    // Example 3: Lower Bounded Wildcard ( ? super Type )
    public void lowerBoundedWildcardExample() {
        List<? super Integer> numbers = new ArrayList<Number>();
        numbers.add(10); // Safe to add Integer
        System.out.println("Lower Bounded Wildcard example executed.");
    }

    public static void main(String[] args) {
        WildcardExamples examples = new WildcardExamples();
        examples.unboundedWildcardExample();
        examples.upperBoundedWildcardExample();
        examples.lowerBoundedWildcardExample();
    }
}