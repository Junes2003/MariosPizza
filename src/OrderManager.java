import java.util.ArrayList;
import java.util.Collections;

public class OrderManager {
    private ArrayList<Order> orders;

    public OrderManager() {
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void listOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders yet.");
        } else {
            Collections.sort(orders);
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    public ArrayList<Order> getOrders(){
        return orders;
    }


    public void registerPayment(int orderID){
        for (int i = 0; i < orders.size(); i++) {
            if (orderID == orders.get(i).getOrderId()){
                orders.get(i).setPaid(true);
                return;
            }
        }
    }
}