package practice.testng;

import java.util.Arrays;

public class VarargsExample {
    // Method to create an array using varargs
    public static int[] createArray(int... elements) {
        return elements;
    }

    public static void main(String[] args) {
        // Example 1: Creating an array with varargs
        int[] arr1 = createArray(1, 2, 3, 4, 5);
        System.out.println("Array 1: " + Arrays.toString(arr1)); // Output: Array 1: [1, 2, 3, 4, 5]

        // Example 2: Creating an array with varargs (no arguments)
        int[] arr2 = createArray();
        System.out.println("Array 2: " + Arrays.toString(arr2)); // Output: Array 2: []

        // Example 3: Creating an array with varargs (single argument)
        int[] arr3 = createArray(10);
        System.out.println("Array 3: " + Arrays.toString(arr3)); // Output: Array 3: [10]

        // Example 4: Creating an array with varargs (mixed data types)
        double[] arr4 = createDoubleArray(1.1, 2.2, 3.3);
        System.out.println("Array 4: " + Arrays.toString(arr4)); // Output: Array 4: [1.1, 2.2, 3.3]
    }

    // Method to create a double array using varargs
    public static double[] createDoubleArray(double... elements) {
        return elements;
    }
}
/**
 * Sure, here are a few examples of how varargs can be used in Java:

1. **Summing Numbers:**
   
   You can use varargs to create a method that sums up a variable number of integers.

   ```java
   public int sum(int... numbers) {
       int result = 0;
       for (int num : numbers) {
           result += num;
       }
       return result;
   }
   ```

   Then you can call this method with any number of integers:

   ```java
   int total = sum(1, 2, 3, 4, 5); // total will be 15
   ```

2. **Formatting Strings:**

   Varargs can be used to create methods that format strings with a variable number of parameters.

   ```java
   public String formatNames(String... names) {
       StringBuilder result = new StringBuilder();
       for (String name : names) {
           result.append(name).append(", ");
       }
       return result.toString();
   }
   ```

   You can call this method with any number of strings:

   ```java
   String formattedNames = formatNames("Alice", "Bob", "Charlie");
   ```

3.Finding Maximum:**

   You can also use varargs to find the maximum of a set of numbers.

   ```java
   public int max(int... numbers) {
       if (numbers.length == 0) {
           throw new IllegalArgumentException("No arguments provided");
       }
       int max = numbers[0];
       for (int i = 1; i < numbers.length; i++) {
           if (numbers[i] > max) {
               max = numbers[i];
           }
       }
       return max;
   }
   ```

   Call this method with any number of integers:

   ```java
   int maximum = max(10, 20, 5, 30); // maximum will be 30
   ```

These are just a few examples of how 
varargs can be used in Java to handle methods that accept a variable number of arguments. They provide a convenient way to work with methods 
where the number of arguments may vary.
 */

