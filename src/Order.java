import java.util.Scanner;

public class Order {
    private String customerOrder;
    private int orderID;
    private double totalPrice;
    private double orderTime;

    public Order() {
    }

    public Order(String customerOrder, int orderID, double totalPrice, double orderTime) {
        this.customerOrder = customerOrder;
        this.orderID = orderID;
        this.totalPrice = totalPrice;
        this.orderTime = orderTime;
    }

    public void addProduct(Product product) {
    }

    public void printLogin() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Velkommen til! Indtast kode for at starte systemet:");
        String startSystem = scan.nextLine();

        String code = "Osman";

        if (startSystem.equals(code)) {
            System.out.println("Du er nu logget ind");
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
