import java.util.Scanner;

// Scanner til at læse brugerinput
public class InputHelper {

    // Farvekoder til konsoltekst
    private static final Scanner scanner = new Scanner(System.in);
    public static final String RED = "\u001B[31m"; // Rød tekst til fejl
    public static final String RESET = "\u001B[0m"; // Nulstil farve
    public static final String BOLD = "\u001B[1m"; // Fed skrift

    // Privat konstruktor for at forhindre oprettelse af objekt
    private InputHelper() {
    }
    // Henter et heltal fra brugeren
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
    // Henter et heltal inden for et bestemt interval
    public static int getIntBoundedInput(String prompt, int start, int end) {
        int input = getIntInput(prompt);
        while (input < start || input >= end) {
            System.out.println(RED + "Ugyldigt valg, prøv igen" + RESET);
            input = scanner.nextInt();
            scanner.nextLine();
        }
        return input;
    }
    // Henter en tekststreng fra brugeren
    public static String getStringInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
    // Henter en boolean (true/false) fra brugeren
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