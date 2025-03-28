public class Accountancy {
    private OrderManager orderManager;

    public Accountancy(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    public double getTotalRevenue() {
        double total = 0;
        for (Order o : orderManager.getOrders()) {
            if (o.getPaid()) {
                total += o.getTotalPrice();
            }
        }

        return total;
    }

    public void printStatistics() {
        System.out.println("Total revenue: " + getTotalRevenue() + " dkk");
        System.out.println("Order amount: " + orderManager.getOrders().size());
    }

    public void accountancyMenu(){
        printStatistics();

        int input = InputHelper.getIntBoundedInput("1 - View active orders\n2 - View paid orders\n", 1, 3);

        switch(input){
            case 1 -> {
                for (int i = 0; i < orderManager.getOrders().size(); i++) {
                    if (!orderManager.getOrders().get(i).getPaid()) {
                        System.out.println(orderManager.getOrders().get(i));
                    }
                }
            }

            case 2 -> {
                for (int i = 0; i < orderManager.getOrders().size(); i++) {
                    if (orderManager.getOrders().get(i).getPaid()) {
                        System.out.println(orderManager.getOrders().get(i));
                    }
                }
            }

            default -> System.out.println(InputHelper.RED + InputHelper.BOLD + "Invalid input! Try again" + InputHelper.BOLD + InputHelper.RESET);

        }

    }
}