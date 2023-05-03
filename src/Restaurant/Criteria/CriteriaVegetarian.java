package Criteria;

import java.util.List;
import java.util.ArrayList;

import Restaurant.Restaurant;

public class CriteriaVegetarian implements Criteria {

    public List<RestaurantUser> meetCriteria(List<RestaurantUser> restaurantUsers) {
        List<RestaurantUser> filteredRestaurants = new ArrayList<>();

        for (RestauranUsert restaurant : restaurantUsers) {
            if (restaurantUser.getRestaurant().isVegetarian()) {
                filteredRestaurants.add(restaurantUser);
            }
        }

        return filteredRestaurants;
    }
}