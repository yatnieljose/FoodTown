package Menu.MenuItem;

public class StudentDiscountDecorator extends DiscountDecorator {
    public StudentDiscountDecorator(MenuItem menuItem) {
        super(menuItem);
    }

    public void getDiscount() {
        this.price = this.price - (this.price * 0.10); // applies 10% student discount
    }
}
