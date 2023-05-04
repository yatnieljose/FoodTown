package Order;

import Observer.Observable;
import Observer.Observer;
import Menu.MenuItem.MenuItem;

import java.util.List;

public class Order implements Observable {
    private OrderStateIF orderState;
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

    public OrderStateIF getOrderState() {
        return this.orderState;
    }

    public void nextState() {
        this.orderState = this.orderState.nextState();
    }

    public String printOrderStatus() {
        return this.orderState.getOrderStatus().toString();
    }
}
