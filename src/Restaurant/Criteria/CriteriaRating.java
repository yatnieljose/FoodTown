package Restaurant.Criteria;

import java.util.List;

import Restaurant.Restaurant;
import User.RestaurantUser;

import java.util.ArrayList;

public class CriteriaRating implements Criteria {
    double minRating;

    public CriteriaRating(double minRating) {
        this.minRating = minRating;
    }

    public List<RestaurantUser> meetCriteria(List<RestaurantUser> restaurants) {
        List<RestaurantUser> filteredRestaurantUsers = new ArrayList<>();

        for (RestaurantUser restaurantUser : restaurants) {
            if (restaurantUser.getRestaurant().getRating() >= this.minRating) {
                filteredRestaurantUsers.add(restaurantUser);
            }
        }

        return filteredRestaurantUsers;
    }
}
