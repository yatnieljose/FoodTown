
public class RestaurantManager {
    List<RestaurantUser> restaurantUsers;

    public RestaurantManager() {
        this.restaurantManagers = new ArrayList<>();
    }

    public void addRestaurantUser(RestaurantUser restaurantUser) {
        this.restaurantManagers.add(restaurantUser);
    }

    public void getRestaurantUsers() {
        return this.restaurantUsers();
    }

    public void filterRestaurants(Criteria filterCriteria) {
        this.restaurantUsers = filterCriteria.meetCriteria(this.restaurantUsers);
    }
}