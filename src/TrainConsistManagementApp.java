import java.util.ArrayList;
import java.util.List;

/**
 * Custom Exception for invalid bogie data
 */
class InvalidCapacityException extends Exception {
    public InvalidCapacityException(String message) {
        super(message);
    }
}

/**
 * MAIN CLASS - UseCase14TrainConsistMgmt
 * -------------------------------------------------------
 * Use Case 14: Exception Handling in Train Management
 * Description: Handles NullPointerException and custom capacity validation.
 */
public class TrainConsistManagementApp {

    public static class Bogie {
        private String name;
        private int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public int getCapacity() { return capacity; }
    }

    /**
     * Validates a list of bogies for nullity and capacity rules.
     */
    public static void validateBogies(List<Bogie> bogies) throws InvalidCapacityException {
        // 1. Handle NullPointerException (Step 2)
        if (bogies == null) {
            throw new NullPointerException("Bogie list is null!");
        }

        // 2. Handle Custom Exception for negative capacity (Step 3)
        for (Bogie b : bogies) {
            if (b.getCapacity() < 0) {
                throw new InvalidCapacityException("Capacity cannot be negative: " + b.getCapacity());
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println(" UC14 - Exception Handling (Null & Custom) ");
        System.out.println("================================================\n");

        // Example Scenario: Valid list
        List<Bogie> train = new ArrayList<>();
        train.add(new Bogie("Sleeper", 72));

        try {
            validateBogies(train);
            System.out.println("Validation Status: PASSED");
        } catch (NullPointerException | InvalidCapacityException e) {
            System.out.println("Validation Status: FAILED - " + e.getMessage());
        }

        System.out.println("\nUC14 validation completed...");

        // Run internal validation tests matching your test case snapshots
        runInternalTests();
    }

    public static void runInternalTests() {
        System.out.println("\n--- Running Exception Validation Tests ---");

        // testException_NullBogieList
        try {
            validateBogies(null);
            System.out.println("Test Null List: FAIL");
        } catch (NullPointerException e) {
            System.out.println("Test Null List: PASS (Caught NPE)");
        } catch (Exception e) { System.out.println("Test Null List: FAIL"); }

        // testException_InvalidCapacity
        try {
            List<Bogie> badTrain = List.of(new Bogie("Faulty", -10));
            validateBogies(badTrain);
            System.out.println("Test Negative Capacity: FAIL");
        } catch (InvalidCapacityException e) {
            System.out.println("Test Negative Capacity: PASS (Caught InvalidCapacityException)");
        } catch (Exception e) { System.out.println("Test Negative Capacity: FAIL"); }

        // testException_ValidBogieData
        try {
            validateBogies(List.of(new Bogie("Good", 50)));
            System.out.println("Test Valid Data: PASS");
        } catch (Exception e) {
            System.out.println("Test Valid Data: FAIL");
        }
    }
}