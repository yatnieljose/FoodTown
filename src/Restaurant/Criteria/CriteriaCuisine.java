package Restaurant.Criteria;

import java.util.List;
import java.util.ArrayList;

import User.RestaurantUser;

public class CriteriaCuisine implements Criteria {
    String cuisine;

    public CriteriaCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public List<RestaurantUser> meetCriteria(List<RestaurantUser> restaurantUsers) {
        List<RestaurantUser> filteredRestaurantUsers = new ArrayList<>();

        for (RestaurantUser restaurantUser : restaurantUsers) {
            if (restaurantUser.getRestaurant().getCuisine() == cuisine) {
                filteredRestaurantUsers.add(restaurantUser);
            }
        }

        return filteredRestaurantUsers;
    }
}
