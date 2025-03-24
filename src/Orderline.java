
public class Orderline {
    private int qty;
    private Product product;
    private double price;

    public Orderline (int qty, Product product, double price) {
        this.qty = qty;
        this.product = product;
        this.price = product.getPrice();
    }
    public int getQty() {
        return qty;
    }

    public Product getProduct() {
        return product;
    }
    public double getTotalPrice() {
        return qty * price;
    }

    @Override
    public String toString() {
        return "Orderline{" + "qty=" + qty + ", product=" + product + ", price=" + price + '}';
         }
    }
