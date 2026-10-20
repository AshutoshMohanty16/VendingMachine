package model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private final Map<String, Item> catalog = new ConcurrentHashMap<>();
    private final Map<String, Integer> stock = new ConcurrentHashMap<>();

    public void addItem(Item item, int quantity) {
        catalog.put(item.getCode(), item);
        stock.put(item.getCode(), quantity);
    }

    public boolean isAvailable(String code) {
        return stock.getOrDefault(code, 0) > 0;
    }

    public Item getItem(String code) {
        return catalog.get(code);
    }

    public void deductStock(String code) {
        stock.put(code, stock.get(code) - 1);
    }

    public int getStock(String code) {
        return stock.getOrDefault(code, 0);
    }
}
