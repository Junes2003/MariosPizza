import java.util.ArrayList;

public class Menu {
    private ArrayList<Product> products; // Liste over pizzaer på menuen
    public ArrayList<Order> orders; // Liste over ordrer

    public Menu() { // Opretter menuen og henter pizzaerne
        products = new ArrayList<>(); // Opretter en tom liste af produkter
        orders = new ArrayList<>(); // Opretter en tom liste af ordrer
        loadMenu(); // Fylder menuen med produkter
    }

    private void loadMenu() { // Tilføjer pizzaer til menuen
        products.add(new Product("No. 1 Vesuvio", 72, "Tomato sauce, cheese, ham"));
        products.add(new Product("No. 2 American", 68, "Tomato sauce, cheese, pepperoni"));
        products.add(new Product("No. 3 Cacciatore", 72, "Tomato sauce, cheese, ham, mushrooms"));
        products.add(new Product("No. 4 Carbonara", 80, "Tomato sauce, cheese, egg, bacon"));
        products.add(new Product("No. 5 Dennis", 83, "Tomato sauce, cheese, ham, pepperoni, bacon"));
        products.add(new Product("No. 6 Bertil", 72, "Tomato sauce, cheese, ham, onion"));
        products.add(new Product("No. 7 Silvia", 76, "Tomato sauce, cheese, artichoke, olives"));
        products.add(new Product("No. 8 Victoria", 76, "Tomato sauce, cheese, ham, mushrooms, bell pepper"));
        products.add(new Product("No. 9 Toronfo", 76, "Tomato sauce, cheese, meat sauce, onion, garlic"));
        products.add(new Product("No. 10 Capricciosa", 76, "Tomato sauce, cheese, ham, mushrooms, olives"));
        products.add(new Product("No. 11 Hawaii", 76, "Tomato sauce, cheese, ham, pineapple"));
        products.add(new Product("No. 12 Le Blissola", 76, "Tomato sauce, cheese, ham, shrimp"));
        products.add(new Product("No. 13 Venezia", 76, "Tomato sauce, cheese, ham, shrimp"));
        products.add(new Product("No. 14 Mafia", 76, "Tomato sauce, cheese, pepperoni, garlic"));
        products.add(new Product("No. 15 Diavola", 82, "Tomato sauce, cheese, spicy salami, chili"));
        products.add(new Product("No. 16 Quattro Formaggi", 85, "Tomato sauce, mozzarella, gorgonzola, parmesan, ricotta"));
        products.add(new Product("No. 17 Parma", 90, "Tomato sauce, cheese, Parma ham, arugula, parmesan"));
        products.add(new Product("No. 18 Margherita", 65, "Tomato sauce, cheese, fresh basil"));
        products.add(new Product("No. 19 Quattro Stagioni", 80, "Tomato sauce, cheese, ham, mushrooms, artichoke, olives"));
        products.add(new Product("No. 20 Rustica", 82, "Tomato sauce, cheese, potato, rosemary, bacon"));
        products.add(new Product("No. 21 Frutti di Mare", 88, "Tomato sauce, cheese, mixed seafood, garlic"));
        products.add(new Product("No. 22 Calzone", 78, "Tomato sauce, cheese, ham, mushrooms (folded pizza)"));
        products.add(new Product("No. 23 BBQ Chicken", 84, "BBQ sauce, cheese, chicken, red onion"));
        products.add(new Product("No. 24 Toscana", 86, "Tomato sauce, cheese, Italian sausage, bell pepper"));
        products.add(new Product("No. 25 Vegetariana", 78, "Tomato sauce, cheese, mushrooms, bell pepper, olives, onion"));
        products.add(new Product("No. 26 Ali", 90, "Cream, mozzarella, potato, rosemary, truffle oil"));
        products.add(new Product("No. 27 Junes", 85, "Tomato sauce, cheese, spicy pepperoni, jalapeños, chili oil"));
        products.add(new Product("No. 28 MO", 79, "Tomato sauce, cheese, anchovies, capers, olives"));
        products.add(new Product("No. 29 Alan", 89, "Tomato sauce, cheese, gorgonzola, pears, walnuts"));
        products.add(new Product("No. 30 Aden", 84, "Tomato sauce, cheese, butter chicken, jalapeños"));
    }

    public ArrayList<Product> getProducts() { // Giver adgang til listen over pizzaer
        return products;
    }

    public void printMenu() { // Viser menuen i terminalen
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public void initializeSystem() {
        OrderManager orderManager = new OrderManager(); // Opretter objekt, så vi kan benytte metoderne i den klasse
        Accountancy accountancy = new Accountancy(orderManager);

        System.out.println("Welcome!");
        boolean running = true;  // Holder programmet kørende
        // Programmet kører, indtil brugeren vælger at afslutte
        while (running) {
            // Viser hovedmenuen
            System.out.println("\n1 - View menu");
            System.out.println("2 - Place new order");
            System.out.println("3 - View placed orders");
            System.out.println("4 - Register payment");
            System.out.println("5 - View revenue summary");
            System.out.println("0 - Exit");

            int choice = InputHelper.getIntInput("");  // Bruger vælger en funktion

            switch (choice) {
                case 1 -> printMenu();  // Viser menuen

                case 2 -> {
                    Order order = new Order();  // Opretter en ny ordre

                    while (true) {
                        // Bruger vælger antal af pizzaer
                        int productQty = InputHelper.getIntInput("Enter quantity");

                        // Bruger vælger en pizza fra menuen (1-31)
                        int productNum = InputHelper.getIntBoundedInput("Enter pizza number", 1, 31);

                        // Tilføjer den valgte pizza til ordren
                        order.addOrderLine(getProducts().get(productNum - 1), productQty);

                        // Spørger om brugeren vil tilføje flere pizzaer
                        String addMore;
                        while (true) {
                            addMore = InputHelper.getStringInput("Would you like to add more? (yes/no)").trim();

                            // Accepterer kun "yes" eller "no" som svar
                            if (addMore.equalsIgnoreCase("no") || addMore.equalsIgnoreCase("yes")) {
                                break;
                            }
                        }

                        // Hvis brugeren ikke vil tilføje mere, afsluttes ordren
                        if (addMore.equalsIgnoreCase("no")) {
                            System.out.println("Order added!");

                            // Viser kvittering
                            System.out.println("\n---- Receipt ----");
                            System.out.println(order);

                            orderManager.addOrder(order);  // Gemmer ordren
                            break;
                        }
                    }
                }

                case 3 -> orderManager.listOrders();  // Viser alle aktive ordrer

                case 4 -> {
                    // Bruger betaler for en ordre
                    int paidOrder = InputHelper.getIntInput("Enter Order ID which is paid for:");
                    orderManager.registerPayment(paidOrder);
                }

                case 5 -> accountancy.accountancyMenu();  // Viser regnskabsoversigten

                case 0 -> running = false;  // Afslutter programmet

                default -> System.out.println("Invalid input! Try again");  // Fejlmeddelelse ved forkert input
            }
        }
    }
}


