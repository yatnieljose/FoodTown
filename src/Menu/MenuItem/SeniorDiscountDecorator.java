package Menu.MenuItem;

public class SeniorDiscountDecorator extends DiscountDecorator {
    public SeniorDiscountDecorator(MenuItem menuItem) {
        super(menuItem);
    }

    public double getDiscount() {
        this.price = this.price - (this.price * 0.10); // applies 15% senior discount
    }
}