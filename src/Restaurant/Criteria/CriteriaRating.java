package Restaurant.Criteria;

import java.util.List;

import Restaurant.Restaurant;

import java.util.ArrayList;

public class CriteriaRating implements Criteria {
    double minRating;

    public CriteriaRating(double minRating) {
        this.minRating = minRating;
    }

    public List<RestaurantUser> meetCriteria(List<RestaurantUser> restaurants) {
        List<RestaurantUser> filteredRestaurantUsers = new ArrayList<>();

        for (RestaurantUser restaurantUser : restaurantUsers) {
            if (restaurantUser.getRestaurant().getRating() >= this.minRating) {
                filteredRestaurants.add(restaurantUser);
            }
        }

        return filteredRestaurants;
    }
}
