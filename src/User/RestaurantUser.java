package User;

import Restaurant.Restaurant;
import Order.Order;
import Order.OrderStatus;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import Menu.Menu;
import Menu.MenuReadWriteLock;
import Menu.MenuItem.MenuItem;

public class RestaurantUser {
    String name;
    Restaurant restaurant;
    Queue<Order> unprocessedOrders;
    List<Order> ordersOutForDelivery;

    public RestaurantUser(String name, String cuisine, double rating, boolean vegetarian, Menu menu) {
        this.name = name;
        this.restaurant = new Restaurant(this, name, cuisine, rating, vegetarian, menu);

        this.unprocessedOrders = new LinkedList<>();
        this.ordersOutForDelivery = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        MenuReadWriteLock menuReadWriteLock = new MenuReadWriteLock(this.restaurant.getMenu());
        menuReadWriteLock.addItem(item);
    }

    public Menu getMenu() {
        return this.restaurant.getMenu();
    }

    public void update(Order order) {
        switch (order.getOrderState().getOrderStatus()) {
            case NEW:
                this.addOrder(order);
            case PREPARING:
                this.processOrder(order);
            case OUT_FOR_DELIVERY:
                this.orderSentForDelivery(order);
            case DELIVERED:
                this.finishOrder(order);
        }
    }

    private void addOrder(Order order) {
        System.out.println("Order received by " + this.restaurant.getName());
        this.unprocessedOrders.add(order);
        //order.nextState();
    }

    public void processOrder(Order order) {
        System.out.println(this.restaurant.getName() + " has processing the Order.");
        this.unprocessedOrders.remove(order);
        //order.nextState();
    }

    private void orderSentForDelivery(Order order) {
        System.out.println("Order picked by by delivery driver from " + this.restaurant.getName());
        this.ordersOutForDelivery.add(order);
        //order.nextState();
    }

    private void finishOrder(Order order) {
        System.out.println(this.restaurant.getName() + " has confirmed delivery of the Order.");
        this.ordersOutForDelivery.remove(order);
    }

    public Restaurant getRestaurant()
    {
        return this.restaurant;
    }
}
