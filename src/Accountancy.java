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

        int input = InputHelper.getIntBoundedInput("\n1 - View active orders\n2 - View paid orders\n3 - View best seller\n0 - Back to menu", 0, 4);

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

            case 3 -> showPopularProducts(); // Kalder metoden

            case 0 -> {} // dirigerer brugeren tilbage

            default -> System.out.println(InputHelper.RED + InputHelper.BOLD + "Invalid input! Try again" + InputHelper.BOLD + InputHelper.RESET); // Fejlmeddelelse for ugyldigt input
        }
    }

    public void showPopularProducts() {
        // Opretter en HashMap, der skal holde styr på antal solgte produkter (pizzas).
        // Nøglen er et Product-objekt (pizzaen), og værdien er antallet af gange den er solgt.
        HashMap<Product, Integer> productCount = new HashMap<>();

        // Itererer over alle ordrer i orderManager (en liste af alle ordrer).
        for (Order order : orderManager.getOrders()) {
            // For hver ordre itereres der over alle OrderLine-objekter (som repræsenterer de specifikke produkter i ordren).
            for (OrderLine orderLine : order.orderLines) {
                // Opdaterer produktcountet i HashMap. Hvis produktet allerede er i HashMap, øges antallet med quantity (mængden i denne ordre).
                // Hvis produktet ikke findes, starter tælleren fra 0 og lægger mængden til.
                productCount.put(orderLine.product, productCount.getOrDefault(orderLine.product, 0) + orderLine.quantity);
            }
        }

        // Udskriver en overskrift for at vise de mest populære produkter (pizzaer).
        System.out.println("\nMost popular pizzas:");

        // Gør HashMap'en om til en stream, så den kan sorteres og vises.
        productCount.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // Sorterer efter værdien (antal solgte) i faldende rækkefølge.
                .forEach(entry ->
                        // Udskriver navnet på produktet (pizzaen) og antallet af solgte enheder.
                        System.out.println(entry.getKey().getName() + " - " + entry.getValue() + " sold")
                );
    }
}
