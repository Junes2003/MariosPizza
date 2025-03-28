import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order implements Comparable<Order> {
    private static int counter = 1; // Tæller for at give hver ordre et unikt ID
    private int orderId; // Ordre-ID
    public ArrayList<OrderLine> orderLines; // Liste over ordrelinjer
    private LocalDateTime orderTime; // Tidspunkt for ordren
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); // Formatter for dato/tid
    private boolean isPaid = false; // Angiver om ordren er betalt

    public Order() { // Opretter en ny ordre med unikt ID og tidsstempel
        this.orderId = counter++;
        this.orderLines = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
    }

    public void addOrderLine(Product product, int quantity) { // Tilføjer en ordrelinje
        orderLines.add(new OrderLine(product, quantity));
    }

    public double getTotalPrice() { // Beregner den samlede pris for ordren
        return orderLines.stream().mapToDouble(OrderLine::getTotalPrice).sum();
    }

    @Override
    public String toString() { // Returnerer en tekstrepræsentation af ordren
        String result = "Order ID: " + orderId + "\n";
        for (OrderLine order : orderLines) {
            result += order + "\n";
        }
        result += "Total: " + getTotalPrice() + " dkk\n";
        result += "Placed: " + orderTime.format(formatter) + "\n";
        result += "Expected done: " + orderTime.plusMinutes(15).format(formatter) + "\n";
        return result;
    }

    public boolean getPaid() { // Returnerer betalingsstatus
        return isPaid;
    }

    public void setPaid(boolean isPaid) { // Opdaterer betalingsstatus
        this.isPaid = isPaid;
    }

    public int getOrderId() { // Returnerer ordre-ID
        return orderId;
    }

    public int compareTo(Order o) { // Sammenligner ordrer baseret på tidspunkt
        return orderTime.compareTo(o.orderTime);
    }

    public LocalDateTime getOrderTime() { // Returnerer tidspunktet for ordren
        return orderTime;
    }
}
