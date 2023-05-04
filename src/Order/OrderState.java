package Order;

public abstract class OrderState implements OrderStateIF {
    OrderStatus orderStatus;
    OrderStateIF nextState;

    protected OrderState(OrderStatus orderStatus, OrderStateIF nextState) {
        this.orderStatus = orderStatus;
        this.nextState = nextState;
    }

    public abstract OrderStateIF nextState();

    public abstract OrderStatus getOrderStatus();
}
