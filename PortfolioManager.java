import java.util.HashMap;
import java.util.Map;

public class PortfolioManager {
    private Map<String, Stock> market;

    public PortfolioManager() {
        market = new HashMap<>();
        market.put("AAPL", new Stock("AAPL", "Apple Inc.", 175.50));
        market.put("GOOGL", new Stock("GOOGL", "Alphabet Inc.", 2825.30));
        market.put("TSLA", new Stock("TSLA", "Tesla Inc.", 750.80));
        market.put("AMZN", new Stock("AMZN", "Amazon.com Inc.", 3342.88));
    }
private Map<String, Stock> market;

    public Map<String, Stock> getMarket() {
        return market;
    }

    public void showMarketData() {
        System.out.println("\n--- Market Data ---");
        for (Stock stock : market.values()) {
            System.out.println(stock);
        }
    }

    public Stock getStock(String symbol) {
        return market.get(symbol.toUpperCase());
    }
}
