import java.util.HashMap;

public class Accountancy {
    private OrderManager orderManager; // Håndterer ordrer

    public Accountancy(OrderManager orderManager) { // Konstruktør der tager en OrderManager som parameter
        this.orderManager = orderManager;
    }

    public double getTotalRevenue() { // Beregner den samlede indtjening fra betalte ordrer
        double total = 0;
        for (Order o : orderManager.getOrders()) {
            if (o.getPaid()) { // Tjekker om ordren er betalt
                total += o.getTotalPrice(); // Lægger prisen til totalen
            }
        }
        return total;
    }

    public void printStatistics() { // Udskriver statistik om ordrer
        System.out.println("Total revenue: " + getTotalRevenue() + " dkk");
        System.out.println("Order amount: " + orderManager.getOrders().size()); // Udskriver antal ordrer
    }

    public void accountancyMenu(){ // Menu til at vise ordrestatus
        printStatistics();

        int input = InputHelper.getIntBoundedInput("\n1 - View active orders\n2 - View paid orders\n3 - View best seller\n", 1, 4);

        switch(input){
            case 1 -> { // Viser aktive (ubetalte) ordrer
                for (int i = 0; i < orderManager.getOrders().size(); i++) {
                    if (!orderManager.getOrders().get(i).getPaid()) { // Tjekker om ordren ikke er betalt
                        System.out.println(orderManager.getOrders().get(i));
                    }
                }
            }

            case 2 -> { // Viser betalte ordrer
                for (int i = 0; i < orderManager.getOrders().size(); i++) {
                    if (orderManager.getOrders().get(i).getPaid()) { // Tjekker om ordren er betalt
                        System.out.println(orderManager.getOrders().get(i));
                    }
                }
            }

            case 3 -> showPopularProducts();

            default -> System.out.println(InputHelper.RED + InputHelper.BOLD + "Invalid input! Try again" + InputHelper.BOLD + InputHelper.RESET); // Fejlmeddelelse for ugyldigt input
        }
    }

    public void showPopularProducts() {
        HashMap<Product, Integer> productCount = new HashMap<>();

        for (Order order : orderManager.getOrders()) {
            for (OrderLine orderLine : order.orderLines) {
                productCount.put(orderLine.product, productCount.getOrDefault(orderLine.product, 0) + orderLine.quantity);
            }
        }

        System.out.println("\nMost popular pizzas:");
        productCount.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // Sorterer fra mest til mindst solgte
                .forEach(entry ->
                        System.out.println(entry.getKey().getName() + " - " + entry.getValue() + " sold")
                );
    }
}
