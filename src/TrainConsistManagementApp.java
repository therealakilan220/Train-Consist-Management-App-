import java.util.HashSet;
import java.util.Set;

/**
 * ==========================================================
 * MAIN CLASS - UseCase3TrainConsistMgmt
 * ==========================================================
 * * Use Case 3: Track Unique Bogie IDs
 * * Description:
 * This class ensures that duplicate bogie IDs are not
 * added into the train formation using HashSet.
 * * At this stage, the application:
 * - Stores bogie IDs
 * - Prevents duplicates automatically
 * - Displays unique bogie identifiers
 * * This maps uniqueness validation using Set.
 * * @author Developer
 * @version 3.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println(" UC3 - Track Unique Bogie IDs ");
        System.out.println("==========================================\n");

        // Create a Set to store unique bogie IDs
        // HashSet stores only unique values
        Set<String> bogieIds = new HashSet<>();

        // ---- ADD IDs (including duplicates) ----
        // add() inserts bogie IDs into the set
        bogieIds.add("B0101");
        bogieIds.add("B0102");
        bogieIds.add("B0103");
        bogieIds.add("B0104");

        // Duplicate entries will be ignored internally by HashSet
        bogieIds.add("B0101"); // Duplicate entry
        bogieIds.add("B0102"); // Duplicate entry

        // Display results
        System.out.println("Bogie IDs After Insertion:");
        System.out.println(bogieIds);

        System.out.println("\nNote:");
        System.out.println("Duplicates are automatically ignored by HashSet.");

        System.out.println("\nUC3 uniqueness validation completed...");
    }
}