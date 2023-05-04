import java.util.ArrayList;
import java.util.List;

import Menu.Menu;
import Restaurant.Criteria.Criteria;
import User.RestaurantUser;

public class RestaurantManager {
    List<RestaurantUser> restaurantUsers;

    public RestaurantManager() {
        this.restaurantUsers = new ArrayList<RestaurantUser>();
        //this.restaurantManagers = new ArrayList<>();
        this.addRestaurantUser(new RestaurantUser(
            "Buca de Faggoncini",
            "Italian",
            3.0,
            false,
        new Menu()));
        this.addRestaurantUser(new RestaurantUser(
            "Krusty Krab", 
            "Mediterranean", 
            5.0, 
            false, 
            new Menu()));
        this.addRestaurantUser(new RestaurantUser(
            "Green Goo",
            "American",
            1.0,
            true, 
            new Menu()));
    }

    public void addRestaurantUser(RestaurantUser restaurantUser) {
        this.restaurantUsers.add(restaurantUser);
    }

    public List<RestaurantUser> getRestaurantUsers() {
        return this.restaurantUsers;
    }

    public void filterRestaurants(Criteria filterCriteria) {
        this.restaurantUsers = filterCriteria.meetCriteria(this.restaurantUsers);
    }
}