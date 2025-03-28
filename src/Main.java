public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        OrderManager orderManager = new OrderManager();
        Accountancy accountancy = new Accountancy(orderManager);

        System.out.println("Welcome!");
        boolean running = true;

        while (running) {
            System.out.println("\n1 - View menu");
            System.out.println("2 - Place new order");
            System.out.println("3 - View placed orders");
            System.out.println("4 - Register payment");
            System.out.println("5 - View revenue summary");
            System.out.println("0 - Exit");

            int choice = InputHelper.getIntInput("");

            switch (choice) {
                case 1 -> menu.printMenu();


                case 2 -> {
                    Order order = new Order();
                    while (true) {
                        int productQty = InputHelper.getIntInput("Enter quantity");

                        int productNum = InputHelper.getIntBoundedInput("Enter pizza number", 1, 31);

//                        while (true) {
//                            if (productNum > 30) {
//                            } else {
//                                break;
//                            }
//                        }

                        order.addOrderLine(menu.getProducts().get(productNum - 1), productQty);

                        String addMore;

                        while (true) {
                            addMore = InputHelper.getStringInput("Would you like to add more? (yes/no)").trim();
//                            if (!addMore.equalsIgnoreCase("no") && !addMore.equalsIgnoreCase("yes")) {
//                                addMore = InputHelper.getStringInput(InputHelper.RED + "Invalid input! Try again" + InputHelper.RESET).trim();
//                            }
                            if (addMore.equalsIgnoreCase("no") || addMore.equalsIgnoreCase("yes")) {
                                break;
                            }
                        }

                        if (addMore.equalsIgnoreCase("no")) {
                            System.out.println("Order added!");

                            System.out.println("\n---- Receipt ----");
                            System.out.println(order);
                            orderManager.addOrder(order);

                            break;
                        }

                    }

                }
                case 3 -> orderManager.listOrders();


                case 4 -> {
                    int paidOrder = InputHelper.getIntInput("Enter Order ID which is paid for:");
                    orderManager.registerPayment(paidOrder);

                }


                case 5 -> accountancy.accountancyMenu();
//                    accountancy.printStatistics();

                case 0 -> running = false;

                default -> System.out.println("Invalid input! Try again");
            }
        }
    }
}