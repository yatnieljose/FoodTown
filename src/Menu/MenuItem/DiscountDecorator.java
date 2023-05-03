package Menu.MenuItem;

public abstract class DiscountDecorator extends MenuItem {
    protected MenuItem menuItem;

    public DiscountDecorator(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public abstract double getDiscount();
}
