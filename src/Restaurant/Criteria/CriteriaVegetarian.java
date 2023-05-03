package Criteria;

import java.util.List;
import java.util.ArrayList;

import Restaurant.Restaurant;

public class CriteriaVegetarian implements Criteria {

    public List<Restaurant> meetCriteria(List<Restaurant> restaurants) {
        List<Restaurant> filteredRestaurants = new ArrayList<>();

        for (Restaurant restaurant : restaurants) {
            if (restaurant.isVegetarian()) {
                filteredRestaurants.add(restaurant);
            }
        }

        return filteredRestaurants;
    }
}