package Order;

public class DeliveredState extends OrderState {
    public DeliveredState() {
        super(OrderStatus.DELIVERED, null);
    }

    @Override
    public OrderStateIF nextState(Order order) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nextState'");
    }

    @Override
    public OrderStatus getOrderStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getOrderStatus'");
    }
}
