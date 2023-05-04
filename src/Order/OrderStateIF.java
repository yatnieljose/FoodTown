package Order;

public interface OrderStateIF
{
    public OrderStateIF nextState(Order order);
    public OrderStatus getOrderStatus();
}