package Restaurant.Criteria;

import java.util.List;

import Restaurant.Restaurant;

import java.util.ArrayList;

public class CriteriaRating implements Criteria {
    double minRating;

    public CriteriaRating(double minRating) {
        this.minRating = minRating;
    }

    public List<Restaurant> meetCriteria(List<Restaurant> restaurants) {
        List<Restaurant> filteredRestaurants = new ArrayList<>();

        for (Restaurant restaurant : restaurants) {
            if (restaurant.getRating() >= this.minRating) {
                filteredRestaurants.add(restaurant);
            }
        }

        return filteredRestaurants;
    }
}
