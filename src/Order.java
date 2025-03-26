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

    public void removeProduct() {

    }
}
