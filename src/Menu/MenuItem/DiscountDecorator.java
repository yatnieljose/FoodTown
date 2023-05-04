package Menu.MenuItem;

public abstract class DiscountDecorator extends MenuItem {
    protected MenuItem menuItem;
    protected double discountPercentage;

    public DiscountDecorator(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public double getDiscount()
    {
        return this.price = this.price - (this.price * discountPercentage);
    }
}
