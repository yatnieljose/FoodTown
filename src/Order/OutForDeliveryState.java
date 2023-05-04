package Order;

public class OutForDeliveryState extends OrderState {
    public OutForDeliveryState() {
        super(OrderStatus.OUT_FOR_DELIVERY, new DeliveredState());
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
