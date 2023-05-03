package Order;

public class NewState {
    public NewState() {
        super(OrderStatus.NEW, new PreparingState());
    }
}
