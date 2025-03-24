public class Product {
   // Product-klassen repræsenterer et produkt (f.eks. en pizza) i pizzabaren.
   // Den har et navn, en pris og en liste af ingredienser.

    // Felterne der gemmer information om produktet
    private String name;
    private double price;
    private String ingredients;


    // Konstruktør: Opretter et nyt produkt med navn, pris og ingredienser.
    public Product (String name, double price, String ingredients) {
        this.name = name; // Navn på produktet f.eks. "Margherita Pizza"
        this.price = price; // Pris på produktet
        this.ingredients = ingredients; // Ingredienser i produktet
    }

    // Getter metode til at hente produktets navn
    public String getName(){ //
        return name;
    }

    // Setter metode til at ændre produktets navn
    public void setName(String name) {
        this.name = name;
    }

    // Getter metode til at hente produktets pris
    public double getPrice(){
        return price;
    }

    // Setter metode til at ændre produktets pris
    public void setPrice(double price){
        this.price = price;

    }

    // Getter metode til at ingredienserne i produktet
    public String getIngredients(){
        return ingredients;
    }

    // Setter metode til at ændre ingredienserne i produktet
    public void setIngredients(String ingredients){
        this.ingredients = ingredients;
    }

    // toString-metoden returnerer en tekstrepræsentation af produktet, hvilket gør det nemmere at udskrive produktinformation
    public String toString() {
    return "Product{" + "Name=" + name + "price=" + price + "ingredients=" + ingredients;}

    public String getName(){
        return name;
    }

}
