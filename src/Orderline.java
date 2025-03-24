
public class Orderline {

    // Felter for at gemme oplysninger om ordren
    private int qty; // Antal enheder af produktet
    private Product product; // Produktet, der er bestilt
    private double price;  // Pris per enhed af produktet

    // Konstruktor til at initialisere en Orderline med mængde (qty), produkt og pris
    public Orderline (int qty, Product product, double price) {
        this.qty = qty; // Sætter mængden af produktet (qty)
        this.product = product; // Sætter produktet
        this.price = product.getPrice(); // Sætter prisen baseret på produktets egen pris
    }
    // Getter-metode til at hente mængden af produktet i ordrelinjen
    public int getQty() {
        return qty; // Returnerer mængden af enheder
    }
    // Getter-metode til at hente produktet i ordrelinjen
    public Product getProduct() {
        return product;  // Returnerer produktet
    }
    // Metode til at beregne den totale pris for denne ordrelinje (qty * price)
    public double getTotalPrice() {
        return qty * price;  // Returnerer den totale pris baseret på mængde og pris per enhed
    }

    // ToString-metode til at returnere en tekstrepræsentation af objektet
    public String toString() {
        return "Orderline{" + "qty=" + qty + ", product=" + product + ", price=" + price + '}';
        // Returnerer en streng med oplysninger om qty, product og price for denne ordrelinje
         }
    }
