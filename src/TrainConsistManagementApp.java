import java.util.*;
import java.util.stream.Collectors;

/**
 * MAIN CLASS - UseCase9TrainConsistMgmt
 * -------------------------------------------------------
 * Use Case 9: Group Bogies by Type
 * Description: Groups similar bogies together using Java Stream Collectors.groupingBy().
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
            return "Capacity -> " + capacity;
        }
    }

    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println(" UC9 - Group Bogies by Type ");
        System.out.println("================================================\n");

        // 1. Create list of bogies (with duplicates for grouping)
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("Sleeper", 70));
        bogies.add(new Bogie("AC Chair", 60));

        // Display input bogies
        System.out.println("All Bogies:");
        for (Bogie b : bogies) {
            System.out.println(b.getName() + " -> " + b.getCapacity());
        }

        // 2, 3, 4. GROUP USING COLLECTORS.GROUPINGBY
        Map<String, List<Bogie>> groupedBogies = bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));

        // 5. Display grouped structure
        System.out.println("\nGrouped Bogies:");
        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nBogie Type: " + entry.getKey());
            for (Bogie b : entry.getValue()) {
                System.out.println(b);
            }
        }

        System.out.println("\nUC9 grouping completed...");

        // Run internal validation tests matching the Test Case Examples
        runInternalTests(bogies, groupedBogies);
    }

    /**
     * Internal test suite to validate requirements from the test case snapshots.
     */
    public static void runInternalTests(List<Bogie> originalList, Map<String, List<Bogie>> groupedResult) {
        System.out.println("\n--- Running Validation Tests ---");

        // testGrouping_BogiesGroupedByType
        boolean test1 = groupedResult.containsKey("Sleeper") && groupedResult.containsKey("AC Chair");
        System.out.println("Test: Categories Classified: " + (test1 ? "PASSED" : "FAILED"));

        // testGrouping_MultipleBogiesInSameGroup
        boolean test2 = groupedResult.get("Sleeper").size() == 2;
        System.out.println("Test: Multiple Bogies In Same Group: " + (test2 ? "PASSED" : "FAILED"));

        // testGrouping_MapStructureValidation
        boolean test3 = groupedResult instanceof Map;
        System.out.println("Test: Map Structure Valid: " + (test3 ? "PASSED" : "FAILED"));

        // testGrouping_OriginalListUnchanged
        boolean test4 = originalList.size() == 5;
        System.out.println("Test: Original Collection Integrity: " + (test4 ? "PASSED" : "FAILED"));

        // testGrouping_EmptyBogieList
        Map<String, List<Bogie>> emptyResult = new ArrayList<Bogie>().stream()
                .collect(Collectors.groupingBy(Bogie::getName));
        System.out.println("Test: Empty Collection Handling: " + (emptyResult.isEmpty() ? "PASSED" : "FAILED"));
    }
}