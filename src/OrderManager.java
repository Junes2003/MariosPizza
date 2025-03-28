import java.util.ArrayList;
import java.util.Collections;

public class OrderManager {
    private ArrayList<Order> orders; // Liste over ordrer

    public OrderManager() { // Initialiserer en tom ordre-liste
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) { // Tilføjer en ordre til listen
        orders.add(order);
    }

    public void listOrders() { // Viser alle ordrer sorteret
        if (orders.isEmpty()) {
            System.out.println("No orders yet."); // Besked hvis ingen ordrer
        } else {
            Collections.sort(orders); // Sorterer ordrerne
            for (Order order : orders) {
                System.out.println(order); // Udskriver hver ordre
            }
        }
    }

    public ArrayList<Order> getOrders() { // Returnerer listen over ordrer
        return orders;
    }

    public void registerPayment(int orderID) { // Markerer en ordre som betalt
        for (int i = 0; i < orders.size(); i++) {
            if (orderID == orders.get(i).getOrderId()) {
                orders.get(i).setPaid(true); // Sætter ordren som betalt
                return;
            }
        }
    }
}