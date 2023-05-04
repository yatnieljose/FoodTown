package Menu;

import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import Menu.MenuItem.MenuItem;

public class MenuReadWriteLock {
    private final Menu menu;
    private final ReadWriteLock readWriteLock;

    public MenuReadWriteLock(Menu menu) {
        this.menu = menu;
        this.readWriteLock = new ReentrantReadWriteLock();
    }

    public void addItem(MenuItem item) {
        this.readWriteLock.writeLock().lock();

        try {
            this.menu.addItem(item);
        } finally {
            this.readWriteLock.writeLock().unlock();
        }
    }

    public MenuItem getItem(String itemName) {
        this.readWriteLock.readLock().lock();

        try {
            return menu.getItem(itemName);
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }

    public Map<String, MenuItem> getAllItems() {
        this.readWriteLock.readLock().lock();

        try {
            return this.menu.getAllItems();
        } finally {
            this.readWriteLock.readLock().unlock();
        }
    }
}