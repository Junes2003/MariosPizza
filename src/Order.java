import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    private ArrayList<Product> orderLine;
    private String customerName;
    private double orderId;
    private boolean isPaid;
    private LocalDateTime pickUpTime;
    private int orderCounter;

    public Order(String customerName, double orderId, boolean isPaid, LocalDateTime pickUpTime) {
        orderLine = new ArrayList<>();
        this.customerName = customerName;
        this.orderId = orderId;
        this.isPaid = isPaid;
        this.pickUpTime = pickUpTime;
        orderCounter = 0;
        orderCounter++;
    }

    public void addProduct(Product product) {
        orderLine.add(product);
    }

    public void printLogin() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Velkommen til! Indtast kode for at starte systemet:");
        String startSystem = scan.nextLine();

        String code = "Osman";

        if (startSystem.equals(code)) {
            System.out.println("Du er nu logget ind");
            System.out.println("Her er menuen:");
        } else {
            while (true) {
                System.out.println("Ugyldigt input! Prøv igen");
                startSystem = scan.nextLine();

                if (startSystem.equals(code)) {
                    System.out.println("Du er nu logget ind");
                    break;
                }
            }

        }
    }
}
