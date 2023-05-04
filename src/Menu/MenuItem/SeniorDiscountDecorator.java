package Menu.MenuItem;

public class SeniorDiscountDecorator extends DiscountDecorator {
    public SeniorDiscountDecorator(MenuItem menuItem) {
        super(menuItem);
        this.discountPercentage = 0.20;
    }
}