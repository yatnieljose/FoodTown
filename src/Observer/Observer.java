package Observer;

import Order.Order;
import Order.OrderStatus;

public interface Observer {
    void update(Order order, OrderStatus orderStatus);
}
