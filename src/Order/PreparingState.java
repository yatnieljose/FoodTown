package Order;

public class PreparingState extends OrderState {
    public PreparingState() {
        super(OrderStatus.PREPARING, new OutForDeliveryState());
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
