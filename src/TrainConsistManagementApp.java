import java.util.Arrays;

/**
 * ##########################################################################
 * MAIN CLASS - UseCase17TrainConsistMgmt
 * ##########################################################################
 * * Use Case 17: Sort Bogie Names Using Arrays.sort()
 * * Description:
 * This class demonstrates sorting of bogie type names
 * alphabetically using Java's built-in Arrays.sort() method.
 * * At this stage, the application:
 * - Creates an array of bogie names
 * - Uses Arrays.sort() for sorting
 * - Displays sorted results
 * * This maps optimized sorting using Java library utilities.
 * * @author Developer
 * @version 17.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("UC17 - Sort Bogie Names Using Arrays.sort()");
        System.out.println("============================================\n");

        // 1. Create an array of bogie type names
        String[] bogieNames = {"Sleeper", "AC Chair", "First Class", "General", "Luxury"};

        // Print Original Bogie Names
        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));
        System.out.println();

        // 2. Use Arrays.sort() to sort the array (Uses Dual-Pivot Quicksort/Timsort)
        // This ensures O(n log n) time complexity and alphabetical order
        Arrays.sort(bogieNames);

        // 3. Print the sorted result using Arrays.toString()
        System.out.println("Sorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));
        System.out.println();

        System.out.println("UC17 sorting completed...");
    }
}