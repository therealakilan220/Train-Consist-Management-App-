import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * MAIN CLASS - UseCase11TrainConsistMgmt
 * -------------------------------------------------------
 * Use Case 11: Validate Train ID and Cargo Code
 * Description: Validates input formats using Regular Expressions (Pattern matching).
 */
public class TrainConsistManagementApp {

    // Regex Rules
    // ^TRN-\\d{4}$ -> Starts with TRN-, followed by exactly 4 digits
    private static final String TRAIN_ID_REGEX = "^TRN-\\d{4}$";
    // ^PET-[A-Z]{2}$ -> Starts with PET-, followed by exactly 2 uppercase letters
    private static final String CARGO_CODE_REGEX = "^PET-[A-Z]{2}$";

    /**
     * Core validation logic using String matches() method
     */
    public static boolean isValid(String input, String regex) {
        if (input == null || input.isEmpty()) return false;
        return input.matches(regex);
    }

    public static void main(String[] args) {
        System.out.println("================================================");
        System.out.println(" UC11 - Validate Train ID and Cargo Code ");
        System.out.println("================================================\n");

        Scanner scanner = new Scanner(System.in);

        // 1. User enters Train ID
        System.out.print("Enter Train ID (Format: TRN-1234): ");
        String trainId = scanner.nextLine();

        // 1. User enters Cargo Code
        System.out.print("Enter Cargo Code (Format: PET-AB): ");
        String cargoCode = scanner.nextLine();

        // 2, 3, 4, 5. Compile, Match, and Validate
        boolean isTrainValid = isValid(trainId, TRAIN_ID_REGEX);
        boolean isCargoValid = isValid(cargoCode, CARGO_CODE_REGEX);

        System.out.println("\nValidation Results:");
        System.out.println("Train ID Valid: " + isTrainValid);
        System.out.println("Cargo Code Valid: " + isCargoValid);

        if (isTrainValid && isCargoValid) {
            System.out.println("\nAll formats are correct. Program continues.");
        } else {
            System.out.println("\nError: One or more inputs follow an invalid format.");
        }

        System.out.println("\nUC11 validation completed...");

        // Run internal tests matching the Test Case Examples provided
        runInternalTests();

        scanner.close();
    }

    /**
     * Internal test suite to validate requirements from the test case snapshots.
     */
    public static void runInternalTests() {
        System.out.println("\n--- Running Regex Validation Tests ---");

        // testRegex_ValidTrainID
        System.out.println("Test Valid Train ID (TRN-1234): " + (isValid("TRN-1234", TRAIN_ID_REGEX) ? "PASS" : "FAIL"));

        // testRegex_InvalidTrainIDFormat
        System.out.println("Test Invalid Train ID (TRAIN12): " + (!isValid("TRAIN12", TRAIN_ID_REGEX) ? "PASS" : "FAIL"));

        // testRegex_TrainIDDigitLengthValidation
        System.out.println("Test Train ID Length (TRN-123): " + (!isValid("TRN-123", TRAIN_ID_REGEX) ? "PASS" : "FAIL"));

        // testRegex_ValidCargoCode
        System.out.println("Test Valid Cargo (PET-AB): " + (isValid("PET-AB", CARGO_CODE_REGEX) ? "PASS" : "FAIL"));

        // testRegex_InvalidCargoCodeFormat
        System.out.println("Test Invalid Cargo (PET-123): " + (!isValid("PET-123", CARGO_CODE_REGEX) ? "PASS" : "FAIL"));

        // testRegex_CargoCodeUppercaseValidation
        System.out.println("Test Cargo Case (PET-ab): " + (!isValid("PET-ab", CARGO_CODE_REGEX) ? "PASS" : "FAIL"));

        // testRegex_EmptyInputHandling
        System.out.println("Test Empty Input: " + (!isValid("", TRAIN_ID_REGEX) ? "PASS" : "FAIL"));

        // testRegex_ExactPatternMatch (rejecting extra characters)
        System.out.println("Test Exact Match (TRN-12345): " + (!isValid("TRN-12345", TRAIN_ID_REGEX) ? "PASS" : "FAIL"));
    }
}