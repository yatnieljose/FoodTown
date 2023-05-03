package Menu;

import java.util.Map;
import java.util.HashMap;

import Menu.MenuItem.MenuItem;

public class Menu {
    private final Map<String, MenuItem> items = new HashMap<>();

    public void addItem(MenuItem item) {
        this.items.put(item.getName(), item);
    }

    public MenuItem getItem(String itemName) {
        return items.get(itemName);
    }
}
