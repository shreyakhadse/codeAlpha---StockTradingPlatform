import java.util.Date;

public class Transaction {
    private String type; // "BUY" or "SELL"
    private Stock stock;
    private int quantity;
    private double totalPrice;
    private Date date;

    public Transaction(String type, Stock stock, int quantity) {
        this.type = type;
        this.stock = stock;
        this.quantity = quantity;
        this.totalPrice = stock.getPrice() * quantity;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return "[" + date + "] " + type + " " + quantity + " shares of " + stock.getSymbol() + " at $" + stock.getPrice();
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
