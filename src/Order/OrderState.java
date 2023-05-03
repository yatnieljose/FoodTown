package Order;

public abstract class OrderState implements OrderStateIF {
    OrderStatus orderStatus;
    OrderStateIF nextState;

    protected OrderState(OrderStatus orderStatus, OrderStateIF nextState) {
        this.orderStatus = orderStatus;
        this.nextState = nextState;
    }

    public abstract void nextState(Order order);

    public abstract OrderStatus getOrderStatus();
}
