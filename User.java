import java.util.*;

public class User {
    private String name;
    private Map<String, Integer> portfolio;
    private List<Transaction> transactions;
    private double balance;

    public User(String name, double initialBalance) {
        this.name = name;
        this.portfolio = new HashMap<>();
        this.transactions = new ArrayList<>();
        this.balance = initialBalance;
    }

    public void buyStock(Stock stock, int quantity) {
        double cost = stock.getPrice() * quantity;
        if (balance >= cost) {
            balance -= cost;
            portfolio.put(stock.getSymbol(), portfolio.getOrDefault(stock.getSymbol(), 0) + quantity);
            transactions.add(new Transaction("BUY", stock, quantity));
            System.out.println("Bought " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void sellStock(Stock stock, int quantity) {
        int currentQty = portfolio.getOrDefault(stock.getSymbol(), 0);
        if (currentQty >= quantity) {
            balance += stock.getPrice() * quantity;
            portfolio.put(stock.getSymbol(), currentQty - quantity);
            transactions.add(new Transaction("SELL", stock, quantity));
            System.out.println("Sold " + quantity + " shares of " + stock.getSymbol());
        } else {
            System.out.println("Not enough shares to sell.");
        }
    }

    public void showPortfolio(Map<String, Stock> market) {
        System.out.println("\n--- Portfolio ---");
        for (String symbol : portfolio.keySet()) {
            int qty = portfolio.get(symbol);
            double currentPrice = market.get(symbol).getPrice();
            System.out.println(symbol + ": " + qty + " shares | Value: $" + (qty * currentPrice));
        }
        System.out.println("Cash balance: $" + balance);
    }

    public void showTransactions() {
        System.out.println("\n--- Transactions ---");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }

    public double getBalance() {
        return balance;
    }
}
