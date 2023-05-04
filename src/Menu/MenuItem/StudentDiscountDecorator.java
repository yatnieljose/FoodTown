package Menu.MenuItem;

public class StudentDiscountDecorator extends DiscountDecorator {
    public StudentDiscountDecorator(MenuItem menuItem) {
        super(menuItem);
        this.discountPercentage = 0.10;
    }
}
