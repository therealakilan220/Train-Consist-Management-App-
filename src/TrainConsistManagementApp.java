import java.util.ArrayList;
import java.util.List;

/**
 * MAIN CLASS - UseCase12TrainConsistMgmt
 * -------------------------------------------------------
 * Use Case 12: Safety Compliance Check for Goods Bogies
 * Description: Enforces safety rules: Cylindrical bogies must carry Petroleum.
 */
public class TrainConsistManagementApp {

    // Goods Bogie model
    public static class GoodsBogie {
        private String type;
        private String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() { return type; }
        public String getCargo() { return cargo; }

        @Override
        public String toString() {
            return type + " -> " + cargo;
        }
    }

    /**
     * Logic for Step 3 & 4: Safety Check using allMatch()
     * Rule: If Type is Cylindrical, Cargo must be Petroleum.
     */
    public static boolean checkSafetyCompliance(List<GoodsBogie> bogies) {
        return bogies.stream().allMatch(b -> {
            if (b.getType().equalsIgnoreCase("Cylindrical")) {
                return b.getCargo().equalsIgnoreCase("Petroleum");
            }
            return true; // Non-cylindrical bogies are always safety-compliant
        });
    }

    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
        System.out.println("================================================\n");

        // 1. Prepare list of goods bogies
        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal")); // This violates the rule

        System.out.println("Goods Bogies in Train:");
        goodsBogies.forEach(System.out::println);

        // 2, 3, 4, 5. Convert to stream and check safety
        boolean isSafe = checkSafetyCompliance(goodsBogies);

        // 6. Display Result
        System.out.println("\nSafety Compliance Status: " + isSafe);
        if (isSafe) {
            System.out.println("Train Formation is SAFE.");
        } else {
            System.out.println("Train Formation is NOT SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");

        // Run internal validation tests
        runInternalTests();
    }

    /**
     * Internal test suite based on Test Case Examples
     */
    public static void runInternalTests() {
        System.out.println("\n--- Running Safety Validation Tests ---");

        // testSafety_AllBogiesValid
        List<GoodsBogie> safeTrain = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Open", "Coal")
        );
        System.out.println("Test All Valid: " + (checkSafetyCompliance(safeTrain) ? "PASS" : "FAIL"));

        // testSafety_CylindricalWithInvalidCargo
        List<GoodsBogie> unsafeTrain = List.of(new GoodsBogie("Cylindrical", "Coal"));
        System.out.println("Test Invalid Cylindrical: " + (!checkSafetyCompliance(unsafeTrain) ? "PASS" : "FAIL"));

        // testSafety_NonCylindricalBogiesAllowed
        List<GoodsBogie> openTrain = List.of(new GoodsBogie("Open", "Petroleum"), new GoodsBogie("Box", "Coal"));
        System.out.println("Test Non-Cylindrical Flexibility: " + (checkSafetyCompliance(openTrain) ? "PASS" : "FAIL"));

        // testSafety_EmptyBogieList
        System.out.println("Test Empty List (Should be True): " + (checkSafetyCompliance(new ArrayList<>()) ? "PASS" : "FAIL"));

        // testSafety_MixedBogiesWithViolation
        List<GoodsBogie> mixedTrain = List.of(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Cylindrical", "Water")
        );
        System.out.println("Test Mixed Violation: " + (!checkSafetyCompliance(mixedTrain) ? "PASS" : "FAIL"));
    }
}