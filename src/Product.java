// Klassen Product repræsenterer et produkt på menuen, f.eks. en pizza.
class Product {
    private String name;  // Navn på produktet (f.eks. "Margherita")
    private double price; // Pris på produktet
    private String ingredients; // Ingredienserne i produktet

    // Contructor til at initialisere produktets egenskaber
    public Product(String name, double price, String ingredients) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }

    // Getter-metode til at hente produktets navn
    public String getName() {
        return name;
    }

    // Getter-metode til at hente produktets pris
    public double getPrice() {
        return price;
    }

    // Overrider toString() for at returnere en beskrivelse af produktet
    @Override
    public String toString() {
        return name + " - " + ingredients + " - " + price + " kr";
    }
}