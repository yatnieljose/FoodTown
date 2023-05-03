package User;

import Restaurant.Restaurant;
import Order.Order;
import Order.OrderStatus;

import java.util.List;
import java.util.ArrayList;

public class RestaurantUser {
    String name;
    Restaurant restaurant;
    List<Order> unprocessedOrders;
    List<Order> ordersOutForDelivery;

    public RestaurantUser(String name, Restaurant restaurant) {
        this.name = name;
        this.restaurant = restaurant;
        this.unprocessedOrders = new ArrayList<>();
        this.ordersOutForDelivery = new ArrayList<>();
    }

    public void update(Order order, OrderStatus orderStatus) {
        switch (orderStatus) {
            case NEW:
                this.addOrder(order);
            case OUT_FOR_DELIVERY:
                this.orderSentForDelivery(order);
            case DELIVERED:
                this.finishOrder(order);
            case PREPARING:
        }
    }

    private void addOrder(Order order) {
        System.out.println("Order received by " + this.restaurant.getName());
        this.unprocessedOrders.add(order);
    }

    private void processOrder(Order order) {
        System.out.println(this.restaurant.getName() + " is Processing the Order.");
        this.unprocessedOrders.remove(order);
    }

    private void orderSentForDelivery(Order order) {
        System.out.println("Order picked by by delivery driver from " + this.restaurant.getName());
        this.ordersOutForDelivery.add(order);
    }

    private void finishOrder(Order order) {
        System.out.println(this.restaurant.getName() + " has confirmed delivery of the Order.");
        this.ordersOutForDelivery.remove(order);
    }
}
