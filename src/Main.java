public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();  // Indeholder listen over pizzaer
        OrderManager orderManager = new OrderManager();  // Håndterer ordrer
        Accountancy accountancy = new Accountancy(orderManager);  // Holder styr på betalinger og regnskab

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
                case 1 -> menu.printMenu();  // Viser menuen

                case 2 -> {
                    Order order = new Order();  // Opretter en ny ordre

                    while (true) {
                        // Bruger vælger antal af pizzaer
                        int productQty = InputHelper.getIntInput("Enter quantity");

                        // Bruger vælger en pizza fra menuen (1-31)
                        int productNum = InputHelper.getIntBoundedInput("Enter pizza number", 1, 31);

                        // Tilføjer den valgte pizza til ordren
                        order.addOrderLine(menu.getProducts().get(productNum - 1), productQty);

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