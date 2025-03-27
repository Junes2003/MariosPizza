import java.util.ArrayList;

public class Menu {
    private ArrayList<Product> products;
    public ArrayList<Order> orders;

    public Menu() {
        products = new ArrayList<>();
        orders = new ArrayList<>();
        loadMenu();
    }

    private void loadMenu() {
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

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void printMenu() {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}


