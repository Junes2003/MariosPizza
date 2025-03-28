public class Product {
    private String name;
    private double price;
    private String ingredients;

    public Product(String name, double price, String ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " - " + ingredients + " - " + price + " kr";
    }
}