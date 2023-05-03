package Order;
import Menu.SubMenu.FoodItem;

public class Order 
{
    private String restaurantID;
    private String userID;
    private FoodItem[] foodItems;
    private OrderStatus orderStatus;

    public Order(String restaurant, String user, FoodItem[] food, OrderStatus status)
    {
        restaurantID = restaurant;
        userID = user;
        foodItems = food;
        orderStatus = status;
    }

    public String getRestaurantID()
    {
        return restaurantID;
    }

    public String getUserID()
    {
        return userID;
    }

    public FoodItem[] getFoodItems()
    {
        return foodItems;
    }

    public double getTotalPrice()
    {
        double total = 0;
        for (FoodItem f : foodItems)
        {
            total += f.getPrice();
        }
        return total;
    }
}
