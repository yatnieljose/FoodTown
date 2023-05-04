package User;
import java.util.List;

import Order.Order;

public class CustomerUser
{
    private String name;
    private List<Order> placedOrders;
    public CustomerUser(String n)
    {
        this.name = n;
    }
}