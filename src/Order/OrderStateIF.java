package Order;

public interface OrderStateIF {
    public OrderStateIF nextState();

    public OrderStatus getOrderStatus();
}