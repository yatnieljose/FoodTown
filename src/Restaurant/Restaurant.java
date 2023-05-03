import Menu.MenuIF;
import Order.Order;

public class Restaurant 
{
    public MenuIF menu;
    private Order[] currentOrders;
    private String name;

    public Restaurant(MenuIF m, String n)
    {
        menu = m;
        name = n;
    }

    public String getName()
    {
        return name;
    }
}
