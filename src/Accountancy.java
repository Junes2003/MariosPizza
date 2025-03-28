public class Accountancy {
    private OrderManager orderManager; // Her gemmer vi en (OrderManager), som holder styr på ordrer

    // Dette er som en opskrift til at lave en ny Accountancy/regnskab. Den får en OrderManager med i starten
    public Accountancy(OrderManager orderManager) {
        this.orderManager = orderManager; // Vi siger Brug denne ordreManager i klassen
    }

    // Denne funktion finder ud af, hvor mange penge vi har tjent på betalte ordrer
    public double getTotalRevenue() {
        double total = 0; // Starter med 0 kroner, fordi vi ikke har talt noget endnu
        for (Order o : orderManager.getOrders()) {
            if (o.getPaid()) { // Hvis ordren er betalt (true)
                total += o.getTotalPrice(); // lægger vi prisen til vores total
            }
        }
        return total; // Til sidst giver vi det samlede beløb tilbage
    }

    // Denne funktion skriver nogle tal om, hvordan det går med ordrerne
    public void printStatistics() {
        // Skriver hvor mange penge vi har tjent
        System.out.println("Total revenue: " + getTotalRevenue() + " dkk");
        // Skriver hvor mange ordrer vi har i alt
        System.out.println("Order amount: " + orderManager.getOrders().size());
    }

    // Dette er en menu, hvor vi kan vælge, hvad vi vil se
    public void accountancyMenu() {
        printStatistics(); // Først viser vi tallene fra før

        // Spørger brugeren: "Hvad vil du se?" (1 eller 2) og gemmer svaret
        int input = InputHelper.getIntBoundedInput("1 - View active orders\n2 - View paid orders\n", 1, 3);

        // Her tjekker vi, hvad brugeren valgte
        switch(input) {
            case 1 -> { // Hvis de vælger 1: Vis ordrer, der ikke er betalt endnu
                // Løkke: Kigger på hver ordre én efter én
                for (int i = 0; i < orderManager.getOrders().size(); i++) {
                    // Hvis ordren IKKE er betalt...
                    if (!orderManager.getOrders().get(i).getPaid()) {
                        // ...viser vi den på skærmen
                        System.out.println(orderManager.getOrders().get(i));
                    }
                }
            }

            case 2 -> { // Hvis de vælger 2: Vis ordrer, der er betalt
                // Løkke: Kigger på hver ordre igen
                for (int i = 0; i < orderManager.getOrders().size(); i++) {
                    // Hvis ordren er betalt
                    if (orderManager.getOrders().get(i).getPaid()) {
                        // viser vi den på terminalen
                        System.out.println(orderManager.getOrders().get(i));
                    }
                }
            }

            default -> // Hvis man skriver noget forkert (ikke 1 eller 2) siger det "Forkert! Prøv igen"
                    System.out.println(InputHelper.RED + InputHelper.BOLD + "Invalid input! Try again" + InputHelper.BOLD + InputHelper.RESET);
        }
    }
}