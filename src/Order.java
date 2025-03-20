public class Order extends Product {
    private String customerOrder;
    private int orderID;
    private double totalPrice;
    private double orderTime;

    public Order(String customerOrder, int orderID, double totalPrice, double orderTime) {
        this.customerOrder = customerOrder;
        this.orderID = orderID;
        this.totalPrice = totalPrice;
        this.orderTime = orderTime;
    }

    public void addProduct(Product product) {

    }
}
