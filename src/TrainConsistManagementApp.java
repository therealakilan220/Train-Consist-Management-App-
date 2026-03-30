import java.util.ArrayList;
import java.util.List;

/**
 * MAIN CLASS - UseCase10TrainConsistMgmt
 * -------------------------------------------------------
 * Use Case 10: Count Total Seats in Train
 * Description: Aggregates seating capacity of all bogies into a single total using Stream reduce().
 */
public class TrainConsistManagementApp {

    // Reusing Bogie model
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

    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println(" UC10 - Count Total Seats in Train ");
        System.out.println("================================================\n");

        // 1. Create list of bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));

        // Display input bogies
        System.out.println("Bogies in Train:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // 2, 3. AGGREGATE USING REDUCE
        // map() extracts capacity, reduce() sums them starting from identity 0
        int totalCapacity = bogies.stream()
                .map(Bogie::getCapacity)
                .reduce(0, (sum, cap) -> sum + cap);

        // 4. Display total seat count
        System.out.println("\nTotal Seating Capacity of Train: " + totalCapacity);

        System.out.println("\nUC10 aggregation completed...");

        // Run internal validation tests matching the Test Case Examples
        runInternalTests(bogies, totalCapacity);
    }

    /**
     * Internal test suite to validate requirements from the test case snapshots.
     */
    public static void runInternalTests(List<Bogie> originalList, int actualTotal) {
        System.out.println("\n--- Running Validation Tests ---");

        // testReduce_TotalSeatCalculation
        int expected = 72 + 56 + 24 + 70; // 222
        System.out.println("Test: Total Sum Calculation: " + (actualTotal == expected ? "PASSED" : "FAILED"));

        // testReduce_SingleBogieHandling
        List<Bogie> singleList = List.of(new Bogie("Solo", 50));
        int singleTotal = singleList.stream().map(Bogie::getCapacity).reduce(0, Integer::sum);
        System.out.println("Test: Single Bogie Handling: " + (singleTotal == 50 ? "PASSED" : "FAILED"));

        // testReduce_EmptyBogieList
        int emptyTotal = new ArrayList<Bogie>().stream().map(Bogie::getCapacity).reduce(0, Integer::sum);
        System.out.println("Test: Empty List Identity (0): " + (emptyTotal == 0 ? "PASSED" : "FAILED"));

        // testReduce_OriginalListUnchanged
        System.out.println("Test: Original Collection Integrity: " + (originalList.size() == 4 ? "PASSED" : "FAILED"));
    }
}