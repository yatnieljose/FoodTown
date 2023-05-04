package Order;

public class PreparingState extends OrderState {
    public PreparingState() {
        super(OrderStatus.PREPARING, new OutForDeliveryState());
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
