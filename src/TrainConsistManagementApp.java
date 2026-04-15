/**
 * ##########################################################################
 * MAIN CLASS - UseCase18TrainConsistMgmt
 * ##########################################################################
 * * * Use Case 18: Linear Search for Bogie ID
 * * * Description:
 * This class demonstrates searching for a specific bogie ID
 * using a simple Linear Search algorithm.
 * * * At this stage, the application:
 * - Creates an array of bogie IDs
 * - Accepts a search key
 * - Traverses array sequentially
 * - Stops when match is found
 * - Displays search result
 * * * This maps basic searching logic using sequential traversal.
 * * * @author Developer
 * * @version 18.0
 */
public class TrainConsistManagementApp {

    public static void main(String[] args) {
        System.out.println("============================================");
        System.out.println("UC18 - Linear Search For Bogie ID");
        System.out.println("============================================\n");

        // 1. Create array of bogie IDs
        String[] bogieIds = {"BG101", "BG205", "BG309", "BG412", "BG550"};

        // 2. Bogie ID to search (Search Key)
        String searchId = "BG309";

        // 3. Display all bogies
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }
        System.out.println();

        // 4. LINEAR SEARCH LOGIC
        // Traverse each element sequentially
        boolean found = false;

        for (String id : bogieIds) {
            // Use .equals() for string comparison in Java
            if (id.equals(searchId)) {
                found = true;
                break; // Stop searching once match is found
            }
        }

        // 5. Display result
        if (found) {
            System.out.println("Bogie " + searchId + " found in train consist.");
        } else {
            System.out.println("Bogie " + searchId + " NOT found in train consist.");
        }

        System.out.println("\nUC18 search completed...");
    }
}