import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Order implements Comparable<Order> {
    private static int counter = 1;
    private int orderId;
    private ArrayList<OrderLine> orderLines;
    private LocalDateTime orderTime;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private boolean isPaid = false;

    public Order() {
        this.orderId = counter++;
        this.orderLines = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
    }

    public void addOrderLine(Product product, int quantity) {
        orderLines.add(new OrderLine(product, quantity));
    }

    public double getTotalPrice() {
        return orderLines.stream().mapToDouble(OrderLine::getTotalPrice).sum();
    }

    @Override
    public String toString() {
//        return "Order ID: " + orderId + "\n" +
//                "Total: " + getTotalPrice() + " dkk\n" +
//                "Placed: " + orderTime.format(formatter) + "\n" +
//                "Expected done: " + orderTime.plusMinutes(15).format(formatter);
        String result = "Order ID: " + orderId + "\n";
        for (OrderLine order : orderLines) {
            result += order + "\n";
        }
        result += "Total: " + getTotalPrice() + " dkk\n";
        result += "Placed: " + orderTime.format(formatter) + "\n";
        result += "Expected done: " + orderTime.plusMinutes(15).format(formatter) + "\n";
        return result;
    }

    public boolean getPaid(){
        return isPaid;
    }

    public void setPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public int getOrderId(){
        return orderId;
    }

    @Override
    public int compareTo(Order o) {
        return orderTime.compareTo(o.orderTime);
//        return o.orderTime.compareTo(orderTime);
    }

    public LocalDateTime getOrderTime(){
        return orderTime;
    }

}