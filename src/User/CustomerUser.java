package User;

import java.util.List;

import Order.Order;
import Observer.Observer;

public class CustomerUser implements Observer {
    private String name;
    private List<Order> placedOrders;

    public CustomerUser(String n) {
        this.name = n;
    }

    public void update(Order order) {
        switch (order.getOrderState().getOrderStatus()) {
            case NEW:
            case PREPARING:
            case OUT_FOR_DELIVERY:
            case DELIVERED:
                this.placedOrders.remove(order);
        }
    }

    public void addOrder(Order order) {
        this.placedOrders.add(order);
    }
}