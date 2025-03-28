import java.util.Scanner;

public class InputHelper {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";
    public static final String BOLD = "\u001B[1m";


    private InputHelper() {
    }

    public static int getIntInput(String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println(RED + "Ugyldigt valg, prøv igen" + RESET);
            scanner.nextLine();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // consumes \n
        return input;
    }

    public static int getIntBoundedInput(String prompt, int start, int end) {
        int input = getIntInput(prompt);
        while (input < start || input >= end) {
            System.out.println(RED + "Ugyldigt valg, prøv igen" + RESET);
            input = scanner.nextInt();
            scanner.nextLine();
        }
        return input;
    }

    public static String getStringInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public static boolean getBooleanInput(String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNextBoolean()) {
            System.out.println(RED + "Invalid input. Try again" + RESET);
            scanner.nextLine();
        }
        boolean input = scanner.nextBoolean();
        scanner.nextLine(); // consumes \n
        return input;
    }
}