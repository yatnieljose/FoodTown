package Order;

public class NewState extends OrderState{
    public NewState() {
        super(OrderStatus.NEW, new PreparingState());
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
