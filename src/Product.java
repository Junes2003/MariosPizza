public class Product {
    private String name;
    private double price;
    public String ingredients;

    public Product (String name, double price, String ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public String getIngredients(){
        return ingredients;
    }
    public void setIngredients(String ingredients){
        this.ingredients = ingredients;
    }
public String toString() {
    return "Product{" + "Name=" + name + "price=" + price + "ingredients=" + ingredients;}

}
