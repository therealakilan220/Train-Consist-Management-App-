import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * MAIN CLASS - UseCase8TrainConsistMgmt
 * -------------------------------------------------------
 * Use Case 8: Filter Passenger Bogies Using Streams
 * Description: Filters bogies based on capacity > 60.
 */
public class TrainConsistManagementApp {

    // Inner Bogie class to model passenger bogies
    public static class Bogie {
        private String name;
        private int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public String getName() { return name; }
        public int getCapacity() { return capacity; }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    /**
     * Logic for Step 2, 3, and 4 of the Flow:
     * Converts list to stream, applies filter, and collects to new list.
     */
    public static List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println(" UC8 - Filter Passenger Bogies Using Streams ");
        System.out.println("================================================\n");

        // 1. User creates a list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        System.out.println("All Bogies:");
        bogies.forEach(System.out::println);

        // Perform Filtering (Threshold > 60)
        List<Bogie> filteredBogies = filterBogies(bogies, 60);

        // 5. Filtered bogies are displayed
        System.out.println("\nFiltered Bogies (Capacity > 60):");
        filteredBogies.forEach(System.out::println);

        System.out.println("\nUC8 filtering completed...");

        // --- Self-Executing Test Section ---
        runInternalTests();
    }

    /**
     * Internal method to simulate the JUnit Test Suite requirements
     */
    public static void runInternalTests() {
        System.out.println("\n--- Running Internal Validation Tests ---");
        List<Bogie> testList = List.of(new Bogie("Sleeper", 72), new Bogie("First Class", 24));

        // Test: Capacity Greater Than Threshold
        boolean test1 = filterBogies(testList, 60).size() == 1;
        System.out.println("Test Greater Than: " + (test1 ? "PASSED" : "FAILED"));

        // Test: Empty List
        boolean test2 = filterBogies(new ArrayList<>(), 60).isEmpty();
        System.out.println("Test Empty List: " + (test2 ? "PASSED" : "FAILED"));

        // Test: Original List Unchanged
        int originalSize = testList.size();
        filterBogies(testList, 60);
        boolean test3 = testList.size() == originalSize;
        System.out.println("Test Original Integrity: " + (test3 ? "PASSED" : "FAILED"));
    }
}