package Restaurant.Criteria;

import java.util.List;
import java.util.ArrayList;

import Restaurant.Restaurant;

public class CriteriaCuisine implements Criteria {
    String cuisine;

    public CriteriaCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public List<Restaurant> meetCriteria(List<Restaurant> restaurants) {
        List<Restaurant> filteredRestaurants = new ArrayList<>();

        for (Restaurant restaurant : restaurants) {
            if (restaurant.getCuisine() == cuisine) {
                filteredRestaurants.add(restaurant);
            }
        }

        return filteredRestaurants;
    }
}
