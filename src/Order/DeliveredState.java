package Order;

public class DeliveredState extends OrderState {
    public DeliveredState() {
        super(OrderStatus.DELIVERED, null);
    }

    @Override
    public OrderStateIF nextState() {
        return this.nextState;
    }

    @Override
    public OrderStatus getOrderStatus() {
        return this.orderStatus;
    }
}
