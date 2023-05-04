import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Restaurant.Criteria.Criteria;
import User.*;

public class OrderController {
    CustomerUser user;
    RestaurantManager restaurantManager;

    public OrderController(CustomerUser user, RestaurantManager restaurantManager) {
        this.user = user;
        this.restaurantManager = restaurantManager;
    }

    public void filterRestaurants(Criteria filterCriteria) {
        this.restaurantManager.filterRestaurants(filterCriteria);
    }

    public ArrayList<RestaurantUser> getRestaurantUsers()
    {
        return (ArrayList<RestaurantUser>)restaurantManager.getRestaurantUsers();
    }

    public Map<String, RestaurantUser> makeRestaurantUserMap(ArrayList<RestaurantUser> rUsers)
    {
        Map<String, RestaurantUser> rStrUsers = new HashMap<>();
        for (RestaurantUser rUser : rUsers)
        {
            rStrUsers.put(rUser.getRestaurant().getName(), rUser);
        }
        return rStrUsers;
    }
}