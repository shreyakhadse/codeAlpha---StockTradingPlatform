import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PortfolioManager manager = new PortfolioManager();
        User user = new User("Alice", 10000); // Initial balance
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. View Transactions");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    manager.showMarketData();
                    break;
                case 2:
                    System.out.print("Enter stock symbol to buy: ");
                    String buySymbol = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int buyQty = scanner.nextInt();
                    Stock buyStock = manager.getStock(buySymbol);
                    if (buyStock != null) {
                        user.buyStock(buyStock, buyQty);
                    } else {
                        System.out.println("Stock not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter stock symbol to sell: ");
                    String sellSymbol = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int sellQty = scanner.nextInt();
                    Stock sellStock = manager.getStock(sellSymbol);
                    if (sellStock != null) {
                        user.sellStock(sellStock, sellQty);
                    } else {
                        System.out.println("Stock not found.");
                    }
                    break;
                case 4:
                    user.showPortfolio(manager.getMarket());
                    break;
                case 5:
                    user.showTransactions();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
