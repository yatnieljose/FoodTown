package Order;

public class NewState extends OrderState {
    public NewState() {
        super(OrderStatus.PREPARING, new OutForDeliveryState());
    }
}
