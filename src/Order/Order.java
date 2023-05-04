package Order;

import Observer.Observable;
import Observer.Observer;
import Menu.MenuItem.MenuItem;

import java.util.List;

public class Order implements Observable {
    private OrderState orderState;
    private Observer customer;
    private Observer restaurant;

    public Order(Observer customer, Observer restaurant, List<MenuItem> menuItems) {
        orderState = new NewState();
        this.customer = customer;
        this.restaurant = restaurant;
    }

    public void notifyObservers() {
        this.customer.update(this);
        this.restaurant.update(this);
    }

    public OrderState getOrderState() {
        return this.orderState;
    }
}
