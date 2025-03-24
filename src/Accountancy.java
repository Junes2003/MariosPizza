import java.util.ArrayList;
import java.util.List;

class Accountancy {
    private List<Order> completedOrders;

    public Accountancy() {
        completedOrders = new ArrayList<>();
    }
    public void addCompletedOrder(Order order) {
        completedOrders.add(order);
    }

    public double getTotalRevenue() {
        return // noget med en sum
    }

    public void printRevenue() {
        System.out.println("Total revenue: " + getTotalRevenue() + " DKK");
    }
}

