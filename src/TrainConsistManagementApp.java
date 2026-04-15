import java.util.Arrays;

/**
 * ##########################################################################
 * MAIN CLASS - UseCase19TrainConsistMgmt
 * ##########################################################################
 * * Use Case 19: Binary Search for Bogie ID
 * * Description:
 * This class demonstrates searching for a specific bogie ID
 * using the Binary Search algorithm on sorted data.
 * * At this stage, the application:
 * - Creates sorted bogie ID array
 * - Defines search key
 * - Applies binary search logic
 * - Narrows search range each iteration
 * - Displays result
 * * This maps optimized searching logic using divide-and-conquer.
 * * @author Developer
 * @version 19.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println(" UC19 - Binary Search for Bogie ID ");
        System.out.println("============================================\n");

        // 1. Create array of bogie IDs
        String[] bogieIds = {"BG309", "BG101", "BG550", "BG205", "BG412"};

        // 2. Ensure data is sorted before binary search (Precondition)
        Arrays.sort(bogieIds);

        // 3. Search key
        String key = "BG309";

        // 4. Display available bogies (Sorted)
        System.out.println("Sorted Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }
        System.out.println();

        // 5. BINARY SEARCH LOGIC
        int low = 0;
        int high = bogieIds.length - 1;
        int resultIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // Compare strings lexicographically
            int comparison = key.compareTo(bogieIds[mid]);

            if (comparison == 0) {
                resultIndex = mid;
                break; // Match found
            } else if (comparison > 0) {
                low = mid + 1; // Search in the right half
            } else {
                high = mid - 1; // Search in the left half
            }
        }

        // 6. Display result
        if (resultIndex != -1) {
            System.out.println("Bogie " + key + " found using Binary Search.");
        } else {
            System.out.println("Bogie " + key + " NOT found.");
        }

        System.out.println("\nUC19 search completed...");
    }
}