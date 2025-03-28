public class OrderLine {
    private Product product; // Produktet
    private int quantity; // Antal

    // Opret en ordrelinje med et produkt og antal
    public OrderLine(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    // Beregn totalpris
    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    // Returnerer en beskrivelse af ordrelinjen i tekstformat
    public String toString() {
        return quantity + "x " + product.getName() + " - " + getTotalPrice() + " dkk";
    }
}