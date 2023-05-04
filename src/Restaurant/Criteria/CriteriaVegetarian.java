package Restaurant.Criteria;

import java.util.List;
import java.util.ArrayList;

import Restaurant.Restaurant;
import User.RestaurantUser;

public class CriteriaVegetarian implements Criteria {

    public List<RestaurantUser> meetCriteria(List<RestaurantUser> restaurantUsers) {
        List<RestaurantUser> filteredRestaurants = new ArrayList<>();

        /*for (RestaurantUser restaurant : restaurantUsers) {
            if (restaurant.getRestaurant().isVegetarian()) {
                filteredRestaurants.add(restaurant);
            }
        }*/

        return filteredRestaurants;
    }
}