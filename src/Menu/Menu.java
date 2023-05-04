package Menu;

import java.util.Map;
import java.util.HashMap;

import Menu.MenuItem.MenuItem;

public class Menu {
    private Map<String, MenuItem> items;

    public Menu() {
        this.items = new HashMap<>();
    }

    public void addItem(MenuItem item) {
        this.items.put(item.getName(), item);
    }

    public MenuItem getItem(String itemName) {
        return this.items.get(itemName);
    }

    public Map<String, MenuItem> getAllItems() {
        return this.items;
    }
}
