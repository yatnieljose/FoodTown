
public class OrderController {
    CustomerUser user;
    RestaurantManager restaurantManager;

    public OrderController(CustomerUser user, RestaurantManager restaurantManager) {
        this.user = user;
        this.retaurantManager = restaurantManager;
    }

    public void filterRestaurants(Criteria filterCriteria) {
        this.restaurantManager.filterRestaurants(filterCriteria);
    }
}