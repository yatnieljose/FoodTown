package Order;

public class NewState extends OrderState {
    public NewState() {
        super(OrderStatus.NEW, new PreparingState());
    }

    @Override
    public OrderStateIF nextState() {
        return this.nextState;
    }

    @Override
    public OrderStatus getOrderStatus() {
        // TODO Auto-generated method stub
        return this.orderStatus;
    }
}
